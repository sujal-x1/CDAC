var express = require('express');
var app = express();

// This responds with "Hello GET" on the homepage for a GET request
app.get('/', function (req, res) {
    console.log('Got a GET request for the homepage');
    res.send('Hello GET');
});

// This responds to a POST request for the homepage
app.post('/', function (req, res) {
    console.log('Got a POST request for the homepage');
    res.send('Hello POST');
});

// This responds to a DELETE request for the /del_user page
app.delete('/del_user', function (req, res) {
    console.log('Got a DELETE request for /del_user');
    res.send('Hello DELETE');
});

// This responds to a GET request for the /list_user page
app.get('/list_user', function (req, res) {
    console.log('Got a GET request for /list_user');
    res.send('Page Listing');
});

// This responds to GET requests for patterns like:
// /abcd, /abxcd, /ab123cd, etc.
app.get('/ab*cd', function (req, res) {
    console.log('Got a GET request for /ab*cd');
    res.send('Page Pattern Match');
});

// Start the server on port 8081
var server = app.listen(8081, '127.0.0.1', function () {
    var host = server.address().address;
    var port = server.address().port;

    console.log(
        'Example app listening at http://%s:%s',
        host,
        port
    );
});
