const cors = require("cors");
const express = require("express");
const mongoose = require("mongoose");
const customersRouter = require("./routes/customers");

const app = express();

app.use(
  cors({
    origin: process.env.CLIENT_ORIGIN || "http://localhost:5173"
  })
);
app.use(express.json({ limit: "16kb" }));

app.get("/api/health", (req, res) => {
  res.json({
    status: "ok",
    database: mongoose.connection.readyState === 1 ? "connected" : "disconnected"
  });
});

app.use("/api/customers", customersRouter);

app.use((error, req, res, next) => {
  if (res.headersSent) {
    return next(error);
  }

  if (error instanceof SyntaxError && error.status === 400 && "body" in error) {
    return res.status(400).json({ message: "Request body must contain valid JSON" });
  }

  if (error.code === 11000) {
    return res.status(409).json({ message: "A customer with this ID already exists" });
  }

  console.error("API request failed:", error);
  res.status(500).json({ message: "An unexpected server error occurred" });
});

module.exports = app;
