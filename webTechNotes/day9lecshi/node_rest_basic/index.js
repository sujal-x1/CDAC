var express = require('express')
var app = express() // instance of server class
var fs = require("fs")
console.log(app)
app.get('/listUsers',function(req,res){
    fs.readFile(__dirname + "/"+"users.json",'utf8',function(err,data){
        console.log("Response data"+res)
        console.log(data)
        res.end(data)
    })
})

var server = app.listen(8081,function(){
    var host= server.address().address
    var port=server.address().port
    console.log("example app listening at http://%s:%s",host,port)
})