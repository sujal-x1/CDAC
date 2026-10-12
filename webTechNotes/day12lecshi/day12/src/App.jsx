import React, { useState } from "react";

function Example() {
  const [count, setCount] = useState(0);
  return (
    <div>
      <p>Bolne k baad bhi ,you clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Mat daba re
      </button>
      {count}
    </div>
  );
}

// function App(){
//   return(
//     <>
//     <h1>Counter kidr hai ?</h1>
//     <br>
//     </br>
//     <Example />

//     </>
//   )
// }

function App() {
  const [no1, setno1] = useState(0);
  const [no2, setno2] = useState(0);
  const [no3, setno3] = useState(0);
  const [rd, setrd] = useState(null);

  const add = () => {
    let result = " "
    if (rd == '+')
      result = (+no1 + +no2);
    else if (rd == '*')
      result = (+no1 * +no2)
    else if (rd == '/')
      result = +no1 / +no2
    setno3(result)
  }


  return (
    <>
      <input name="no1" value={no1} onChange={(e) => setno1(e.target.value)} />

      <input name="no2" value={no2} onChange={(e) => setno2(e.target.value)} />

      <button type="button" onClick={add}>add</button>

      <input name="no3" value={no3} disabled={true} />

      <input type='radio' name="rd" value='+' checked={rd === '+'} onChange={(e) => setrd(e.target.value)} />+

      <input type='radio' name="rd" value='*' checked={rd === '*'} onChange={(e) => setrd(e.target.value)} />*

      <input type='radio' name="rd" value='/' checked={rd === '/'} onChange={(e) => setrd(e.target.value)} />/
    </>
  );
}
export default App;

//   const add=()=>setno3(+no1 + +no2);
//   return(
//     <>
//     <input name = "no1" value={no1} onChange={(e)=>setno1(e.target.value)}/>
//     <input name = "no2" value={no2} onChange={(e)=>setno2(e.target.value)}/>
//     <button type = "button" onClick={add}>add</button>
//     <input name = "no3" value={no3} disabled={true}/>
//     </>
//   )
// }

// export default App;