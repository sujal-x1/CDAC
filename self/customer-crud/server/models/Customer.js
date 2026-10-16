const mongoose=require("mongoose");

const customerSchema = new mongoose.Schema({
    id:{
        type: Number,
        required: true,
        unique: true
    },
    name:{
        type: String,
        required:true,
        unique: true
    },
    mobile:String,
    email: String,
    address:String,
    image:String
});

module.exports = mongoose.model("Customer",customerSchema);