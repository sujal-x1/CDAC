var express = require('express');
var app = express();
var fs = require("fs");
app.get('/:id', function (req, res) {
    //      First read existing users.
    fs.readFile(__dirname + "/" + "user2.json", 'utf8', function (err, data) {
        var users = JSON.parse(data);
        var user = users["user2" + req.params.id]
        console.log(user);
        res.end(JSON.stringify(user));
    });
})

var server = app.listen(8081, function () {
    var host = server.address().address
    var port = server.address().port
    console.log("Example app listening at http://%s:%s", host, port)
})

