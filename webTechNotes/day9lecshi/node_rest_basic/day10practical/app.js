var express = require('express');
var app = express();

// Parse form data sent using POST
app.use(express.urlencoded({ extended: false }));

// GET form
app.get('/getform', function (req, res) {
    res.sendFile(__dirname + '/04get_form.html');
});

// Process GET form
app.get('/process_get', function (req, res) {
    var response = {
        first_name: req.query.first_name,
        last_name: req.query.last_name
    };

    console.log(response);
    res.json(response);
});

// POST form
app.get('/postdata', function (req, res) {
    res.sendFile(__dirname + '/05post_form.html');
});

// Process POST form
app.post('/process_post', function (req, res) {
    var response = {
        first_name: req.body.first_name,
        last_name: req.body.last_name
    };

    console.log(response);
    res.json(response);
});

// Start server
var server = app.listen(8081, function () {
    var host = server.address().address;
    var port = server.address().port;

    console.log("Example app listening at http://%s:%s", host, port);
});
