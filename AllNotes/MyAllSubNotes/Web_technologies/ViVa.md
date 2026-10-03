call()    → call function now, custom this
apply()   → call function now, custom this + array arguments
bind()    → `bind()` also sets `this`, but unlike `call()` and `apply()`, it **doesn't immediately execute the function**.

map()     → transform elements

```js
const numbers = [1, 2, 3, 4];

const result = numbers.map(num => num * 2);

console.log(result);
```

filter()  → select elements(only odd nums)
reduce()  → combine elements into one value (1,2,3)=>6

### Q. callback()
--> callback function accepts anther function in parameters and executes it after