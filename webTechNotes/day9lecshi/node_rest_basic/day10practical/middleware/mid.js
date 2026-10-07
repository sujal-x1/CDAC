const express = require('express')
const app = express();
 
app.use ((req,res,next)=>{
    console.log('Middleware 1 : this always runs')
    next()
})

app.use ((req,res,next)=>{
    console.log('Mideleware 2 : this also always runs')
})

app.get('/',(req,res)=>{
    res.send('Hello world!')
})

app.listen(8080,()=>{
    console.log('server runninng on port 8080')
})