import { useState } from "react";
export default function App(){
    return(
        <div>
            <h1>counters that update separately</h1>
        <MyButton />
        <MyButton />
        </div>
    )
}

function MyButton(){
const[count,setcounter]=useState(0)

function handleClick(){
    setcounter(count+1)
}
return(
<button onClick={handleClick}>
clicked {count}times
</button>
)
}