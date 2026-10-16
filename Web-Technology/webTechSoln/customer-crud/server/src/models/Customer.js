const mongoose = require("mongoose");

const customerSchema = new mongoose.Schema(
  {
    id: {
      type: Number,
      required: true,
      unique: true,
      min: 1
    },
    name: {
      type: String,
      required: true,
      trim: true,
      maxlength: 120
    },
    mobile: { type: String, maxlength: 40, default: "" },
    email: { type: String, maxlength: 254, default: "" },
    address: { type: String, maxlength: 500, default: "" },
    image: { type: String, maxlength: 500, default: "" }
  },
  { timestamps: true }
);

module.exports = mongoose.model("Customer", customerSchema);
