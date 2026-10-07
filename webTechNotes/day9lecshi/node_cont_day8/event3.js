var events = require('events');
var eventEmitter = new events.EventEmitter();
 // listener #1
var listner1 = function listner1(n) {
     console.log('listner1 executed.'+n+n);
}
 // listener #2
var listner2 = function listner2(n) {
   console.log('listner2 executed.'+n*n);
}
 // Bind the connection event with the listner1 function
eventEmitter.addListener('connection', listner1);
 // Bind the connection event with the listner2 function
eventEmitter.on('connection', listner2);
  // Fire the connection event 
eventEmitter.emit('connection',5);
console.log(eventEmitter.listeners('connection'))
// Remove the binding of listner1 function
eventEmitter.removeListener('connection', listner1);
console.log("Listner1 will not listen now.");
 // Fire the connection event 
eventEmitter.emit('connection',7);
  console.log("Program Ended.");
 
