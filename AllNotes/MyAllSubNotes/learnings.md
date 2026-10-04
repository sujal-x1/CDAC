## Async , await , promise, then
```js
<script>
        async function getMessage(){
            let promise = new Promise((resolve,reject)=>{
                setTimeout(()=>resolve("done"),2000)
            })//create a async function with promise and timeout
            const result = await promise//using await to wait for result else it's return fullfilled

            return result // then return result ie: done

        }

        getMessage().then((result)=>{console.log("then executed",result)}, 
//.then is used with promise so here getMessage is a promise (result is a param)
//when we get result get above or when its error do below 
        (error)=>{console.log("then error",error)})

    </script>
```

