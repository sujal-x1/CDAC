import { useState, useEffect } from "react";
import { fetchBio } from "./api";

export default function Timer() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const timer = setTimeout(() => {
      setCount((count) => count + 1);
    }, 1000);

    return () => clearTimeout(timer);
  }, [count]);

  return <h1>I've rendered {count} times!</h1>;
}


export function Counter() {
  const [count, setCount] = useState(0);
  const [calculation, setCalculation] = useState(0);

  useEffect(() => {
    setCalculation(() => count * 2);
  }, [count]);

  return (
    <>
      <p>Count: {count}</p>

      <button onClick={() => setCount((c) => c + 1)}>
        +++
      </button>

      <p>Calculation: {calculation}</p>
    </>
  );
}



