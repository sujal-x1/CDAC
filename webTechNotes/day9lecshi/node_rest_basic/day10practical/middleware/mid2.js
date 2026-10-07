const express = require('express')
const app = express()

const myLogger = function(req,res,next){
    console.log("logged")
    next()
}
const requestTime = function(req,res,next){
    req.requestTime = Date.now()
    next()
}

app.use(myLogger)
app.use(requestTime)
app.get('/',(req,res)=>{
   let responseText = 'Hello World!<br>'
 responseText += `<small>Requested at: ${req.requestTime}</small>`
 res.send(responseText)
})
app.get('/', (req, res) => {
 res.send('Hello World!')
})
app.listen(3000)
