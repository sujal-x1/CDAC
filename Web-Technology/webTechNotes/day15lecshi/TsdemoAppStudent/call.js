"use strict";
function call(a, b = 1) {
    let p;
    p = a * b;
    return p;
}
let x, y;
x = 5;
y = 7;
const r = call(x);
console.log(r);
console.log(call(3, 3));
