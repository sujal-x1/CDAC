

const express = require("express");
const router = express.Router();
const Customer = require("../models/Customer");

function checkLogin(req, res, next) {
  if (req.headers["x-username"] !== "VITA") {
    return res.status(403).json({
      message: "Only VITA can access this operation"
    });
  }

  next();
}

// CREATE
router.post("/", checkLogin, async (req, res) => {
  try {
    const lastCustomer = await Customer.findOne().sort({ id: -1 });
    const nextId = lastCustomer ? lastCustomer.id + 1 : 1;

    const customer = await Customer.create({
      id: nextId,
      name: req.body.name,
      mobile: req.body.mobile,
      email: req.body.email,
      address: req.body.address,
      image: req.body.image
    });

    res.status(201).json(customer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

//READ ALL
router.get("/", checkLogin , async(req,res)=>{
    try{
        const customers = await Customer.find().sort({id:1});
        res.json(customers);
    }catch(err){
        res.status(500).json({message: err.message})
    }
})

//READ ONE

router.get("/:id",checkLogin,async(req,res)=>{
    try{
        const customer= await Customer.findOne({
            id:Number(req.params.id)
        })
        if(!customer){
            return res.status(404).json({message: "Customer not found"})
        }
        req.json(customer);
    }catch(err){
        res.status(500).json({message:err.message})
    }
})

// UPDATE
router.put("/:id", checkLogin, async (req, res) => {
  try {
    const customer = await Customer.findOneAndUpdate(
      { id: Number(req.params.id) },
      {
        name: req.body.name,
        mobile: req.body.mobile,
        email: req.body.email,
        address: req.body.address,
        image: req.body.image
      },
      { new: true, runValidators: true }
    );

    if (!customer) {
      return res.status(404).json({
        message: "Customer not found"
      });
    }

    res.json(customer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});
//DELETE

router.delete("/:id",checkLogin,async(req,res)=>{
    try{
        const customer = await Customer.findOneAndDelete({
            id:Number(req.params.id)
        });
        if(!customer){
            return res.status(404).json({
                message: "Customer not found"
            })
        }
        res.json({
            message:"Customer deleted successfully"
        })
    } catch(err){
        res.status(500).json({message: err.message})
    }
})
module.exports =router;

