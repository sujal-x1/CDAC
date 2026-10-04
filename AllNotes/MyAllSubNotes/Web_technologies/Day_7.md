## notes
- of is used in arrays to get kv pairs

## Async-Await
A function declared with async , means it  will return a promise

<script>
async function f(){
return 1;
}
f().then((dd)=>alert(dd),(err)=alert(err));
console.log(f())
</script>

## Fetch (for lab test)
fetch has return type promise, after promise resolves we get response

## optional chaining ?.
```js
user?.address?.street
```
"If user exists, get address; if address exists, get street; otherwise give me undefined."

## regular expression 😭 (see some of em)

