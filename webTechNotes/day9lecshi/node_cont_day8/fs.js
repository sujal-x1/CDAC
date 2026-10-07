const fs = require('fs');
// Create a readable stream for a file
const stream = fs.createReadStream('users.json', { encoding: 'utf8' });
// Listen for the "open" event (file descriptor opened)
stream.on('open', () => {
     console.log('File has been opened.');
});
// Listen for the "data" event (chunks of file data)
stream.on('data', (chunk) => {
     console.log('Received data chunk:', chunk);
});

// Listen for the "error" event (something went wrong)
stream.on('error', (err) => {
     console.error('Error occurred:', err.message);
});

// Listen for the "end" event (finished reading)
stream.on('end', () => {
     console.log('Finished reading file.');
});

// Listen for the "close" event (stream closed)
stream.on('close', () => {
     console.log('Stream closed.');
});
