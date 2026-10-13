// let a: number;
// a=55;
// a= "hello";

// console.log(a);
// let myName: string="hello"
// console.log(myName)

let names:string[]=['John','Jane','Peter','David','Mary'];

let greeting:(name:string)=>string;

greeting = function(name:string){
    return `HI $(name)`
}
console.log(greeting)