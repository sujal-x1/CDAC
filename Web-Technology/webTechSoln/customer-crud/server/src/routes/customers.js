const express = require("express");
const Customer = require("../models/Customer");
const { parseCustomerId, validateCustomerInput } = require("../validation");

const router = express.Router();

router.use((req, res, next) => {
  if (req.get("x-username") !== "VITA") {
    return res.status(403).json({
      message: "Only VITA can access customer operations"
    });
  }

  next();
});

router.get("/", async (req, res, next) => {
  try {
    const customers = await Customer.find().sort({ id: 1 }).lean();
    res.json(customers);
  } catch (error) {
    next(error);
  }
});

router.get("/:id", async (req, res, next) => {
  const id = parseCustomerId(req.params.id);
  if (id === null) {
    return res.status(400).json({ message: "Customer ID must be a positive integer" });
  }

  try {
    const customer = await Customer.findOne({ id }).lean();
    if (!customer) {
      return res.status(404).json({ message: "Customer not found" });
    }

    res.json(customer);
  } catch (error) {
    next(error);
  }
});

router.post("/", async (req, res, next) => {
  const validation = validateCustomerInput(req.body);
  if (validation.error) {
    return res.status(400).json({ message: validation.error });
  }

  try {
    const lastCustomer = await Customer.findOne().sort({ id: -1 }).select("id").lean();
    const customer = await Customer.create({
      ...validation.value,
      id: lastCustomer ? lastCustomer.id + 1 : 1
    });

    res.status(201).json(customer);
  } catch (error) {
    next(error);
  }
});

router.put("/:id", async (req, res, next) => {
  const id = parseCustomerId(req.params.id);
  if (id === null) {
    return res.status(400).json({ message: "Customer ID must be a positive integer" });
  }

  const validation = validateCustomerInput(req.body);
  if (validation.error) {
    return res.status(400).json({ message: validation.error });
  }

  try {
    const customer = await Customer.findOneAndUpdate(
      { id },
      { $set: validation.value },
      { new: true, runValidators: true }
    );

    if (!customer) {
      return res.status(404).json({ message: "Customer not found" });
    }

    res.json(customer);
  } catch (error) {
    next(error);
  }
});

router.delete("/:id", async (req, res, next) => {
  const id = parseCustomerId(req.params.id);
  if (id === null) {
    return res.status(400).json({ message: "Customer ID must be a positive integer" });
  }

  try {
    const customer = await Customer.findOneAndDelete({ id });
    if (!customer) {
      return res.status(404).json({ message: "Customer not found" });
    }

    res.json({ message: "Customer deleted successfully" });
  } catch (error) {
    next(error);
  }
});

module.exports = router;
