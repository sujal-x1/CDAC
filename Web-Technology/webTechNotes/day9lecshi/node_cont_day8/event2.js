var events = require('events')
var eventEmitter = new events.EventEmitter()

var listner1=function listner1(){
    console.log('listner1 executed')
}

var listner2 = function listner(){
    console.log('listner2 executed')
}

eventEmitter.addListener('connection',listner1)

eventEmitter.on('connection',listner2)
console.log(eventEmitter.listeners('connection'))

eventEmitter.emit('connection')

eventEmitter.removeListener('connection',listner1)
console.log("listner1 will not listen now")

eventEmitter.emit('connection')
console.log("Program Ended")