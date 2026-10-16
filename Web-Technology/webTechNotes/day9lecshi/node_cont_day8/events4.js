const http = require('http')
const server = http.createServer((req,res)=>{
    console.log('request event fired')
    res.writeHead(200,{'Content-Type': 'text'})
    res.end('Hello world\n')
})

server.on('connection', (socket) => {
    console.log('Connection event fired!');
});

// Fired when the server closes
server.on('close', () => {
    console.log('Server closed.');
});

// Start listening
server.listen(3000, () => {
    console.log('Server listening on port 8081');
});
