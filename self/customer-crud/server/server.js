const express = require("express");
const mongoose = require("mongoose");
const cors  = require("cors");

const app = express();

app.use(cors());
app.use(express.json()) 

mongoose.connect("mongodb://127.0.0.1:27017/customerdb")
.then(()=>console.log("Mongodb connected")).catch((err)=>console.log("mongodb err :" err))

app.use("/api/customers", require("./routes/customers"))

app.get("/",(req,res)=>{
    res.send("customer crud api is running")
})

app.listen(5000,()=>{
    console.log("server running at http://localhost:5000")
})


