import { useState } from "react";

export default function App(){
    const [count,setCount]=useState(0)

    function handleClick(){
        setCount(count+1)
    }
    return (
    <>
    <h1>Counters that update together</h1>  
    <MyButton count={count} onClick={handleClick}/>
    <MyButton count={count} onClick={handleClick}/>
    </>
)
}



function MyButton({count, onClick}){
    return(
        <button onClick={onClick}>
            Clicked {count} times
        </button>
    )
}