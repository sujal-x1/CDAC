function call (a:number,b:number=1):number{
    let p: number;
    p=a*b;
    return p;
}

let x: number,y:number;
x=5
y=7

const r: number = call(x)
console.log(r)

console.log(call(3,3))