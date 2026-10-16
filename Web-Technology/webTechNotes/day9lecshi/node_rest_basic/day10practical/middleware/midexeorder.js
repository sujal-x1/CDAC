const express = require('express');
const app = express();

// This middleware will run first
app.use((req, res, next) => {
    console.log('First middleware');
    next();
});

// This middleware will run for /users paths only
app.use('/users', (req, res, next) => {
    console.log('Users middleware');
    next();
});

// This route handler will run when matched
app.get('/users', (req, res) => {
    res.send('Users list');
});
// This middleware will never run for successfully matched routes
// because route handlers end the request-response cycle
app.use((req, res, next) => {
    console.log('This will not run for matched routes');
    next();
});
// This is a "catch-all" middleware for unmatched routes
app.use((req, res) => {
    res.status(404).send('Not found');
});
app.listen(8888)
