import "./App.css"
function Header(){
  return <h1>Hello Sm Vita</h1>
}

function Footer(){
  return <footer>© Copyright</footer>
}

function App(){
  return(
    <div>
      <Header />
      <div>
      <img src="https://png.pngtree.com/png-vector/20240205/ourmid/pngtree-red-bricks-isolated-for-decorative-png-image_11626390.png" alt="vita"></img>
      <img src="https://png.pngtree.com/png-vector/20240205/ourmid/pngtree-red-bricks-isolated-for-decorative-png-image_11626390.png" alt="vita"></img>
      <p>Sm Vita</p>
      </div>
      {/* Body will go here */}
      <Footer />
    </div>
  )
}
export default App;