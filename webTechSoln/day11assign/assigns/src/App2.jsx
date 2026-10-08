import "./App.css"

function Button (){
  return <button onClick={Clicked}>Click clack</button>
}

function Clicked(){
  alert("button mat daba re!!")
}

function App(){
  return(
  <div>
  <h1>this is THE BUTTON</h1>
  <br></br>
  <Button />
  <br></br>
    <br></br>

  <footer>"under" THE BUTTON</footer>
  </div>
  )
}

export default App;

