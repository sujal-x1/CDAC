# JavaScript

- JavaScript is used for **client-side validation** and **rendering/manipulating the page**.
    
- If we don't specify a file name when loading a website, the server commonly loads `index.html` as the default page.
    
- JavaScript is a **dynamic programming language** and is **object-based**.
    
- `<script>` is used to add JavaScript to HTML.
    

## Variables

- `var` allows **redeclaring** a variable.
    
- The scope of a variable depends on how it is declared:
    
    - `var` → function scope
        
    - `let` → block scope
        
    - `const` → block scope
        

## Operators

### `==` — Loose Equality

Checks whether two values are equal after type conversion when necessary.

```javascript
5 == 8   // false
5 == "5" // true
```

### `===` — Strict Equality

Checks both **value and type**.

```javascript
5 === 8   // false
5 === "5" // false
5 === 5   // true
```

## Methods and Properties

- **Parentheses `()` → Method**
    
    - A method is something you call/execute.
        
    - Example:
        
        ```javascript
        "hello".toString()
        ```
        
- **No parentheses → Property**
    
    - A property provides information about an object.
        
    - Example:
        
        ```javascript
        "hello".length
        ```

- **undeclared by inititalized var will not give any error**
- `< br> is line break / nextLine
- ## let, var, const is a keyword & not a datatype
- `'use strict'` is a mode in which assignment to undeclared variable will raise an error , must use `let ,var ,const

- `const` ***declare variable and initailize in 1 line
```
const Max_items=30; //valid
```

## `in js class and function are same`

- **any calculation between undefine and data wll result into Not a number "NaN"
- Type of undefined is Undefined and type of object is object 
- first string and then num will concat everything use () to avoid --> ans="+(a+b)
- ```let``` is a scope level variable 
- var has declaration above the for loop 
- reference is constant , it cannot be changed  but it's property can be changed like (name,age etc)
- use Object.freeze() to make object immutable
- by default function will return undefined 
- document.write(call) //without parenthesis will return entire function definition
- Default parameter hat to be last, else it will be a syntax error probably
- elipse== array                  function multiply(...myarg)


## `Elipses - uses
## 1. Rest parameter — collecting values

This is what you just used:

```javascript
function test(a, b, ...rest) {
    console.log(a);
    console.log(b);
    console.log(rest);
}

test(10, 20, 30, 40, 50);
```

Output:

```text
10
20
[30, 40, 50]
```

Here `...rest` **collects** the remaining arguments into an array.

Think:

```text
10 → a
20 → b
30 ┐
40 ├──→ rest = [30, 40, 50]
50 ┘
```

---

## 2. Spread syntax — unpacking values

The same `...` can do the opposite: **unpack** an array.

```javascript
let arr = [10, 20, 30];

console.log(...arr);
```

This is roughly like writing:

```javascript
console.log(10, 20, 30);
```

So:

```text
Rest   → collect
Spread → unpack
```

---

## 3. Spread when calling a function

Suppose:

```javascript
function add(a, b, c) {
    return a + b + c;
}

let numbers = [10, 20, 30];

console.log(add(...numbers));
```

`...numbers` unpacks the array:

```javascript
add(10, 20, 30);
```

So the result is:

```text
60
```

Without `...`:

```javascript
add(numbers);
```

you're passing the **entire array as the first argument**.

---

## 4. Copying an array

You can use spread to make a new array:

```javascript
let a = [1, 2, 3];

let b = [...a];

console.log(b);
```

Result:

```text
[1, 2, 3]
```

Now `b` is a separate array.

You can also combine arrays:

```javascript
let a = [1, 2];
let b = [3, 4];

let c = [...a, ...b];

console.log(c);
```

Result:

```text
[1, 2, 3, 4]
```

---

## 5. Spread with objects

You can do the same thing with objects:

```javascript
let person = {
    name: "SJ",
    age: 20
};

let person2 = {
    ...person,
    city: "Mumbai"
};
```

Now:

```javascript
console.log(person2);
```

gives:

```text
{
    name: "SJ",
    age: 20,
    city: "Mumbai"
}
```

Here `...person` copies the properties from `person` into the new object.
