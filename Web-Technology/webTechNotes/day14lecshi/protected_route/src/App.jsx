import { useRef, useState } from 'react'
import './App.css'
import {
  BrowserRouter,
  Link,
  Route,
  Routes
} from 'react-router-dom'

import Protected from './Protected'
import Dashboard from './Dashboard'
import Home from './Home'
import Product from './Product'
import MarkdownEditor from './MarkdownEditor'
import Component1 from './Component1'
import CountRender from './CountRender'

function App() {
  const [isSignedIn, setIsSignedIn] = useState(false)
    const paraRef = useRef();

  const changeColor = () => {
    // Directly update the DOM element’s style
    paraRef.current.style.color = "blue";
  };
  return (
    
    <BrowserRouter>
      <div>
        <h2>React Protected Routes Example</h2>

        <nav>
          <Link to="/home">Home</Link> {' | '}
          <Link to="/dashboard">Dashboard</Link> {' | '}
          <Link to="/product">Product</Link> {' | '}
          <Link to="/markdown">Markdown Editor</Link> {' | '}
          <Link to="/component1">Create Context</Link>
        </nav>

        {isSignedIn ? (
          <button onClick={() => setIsSignedIn(false)}>
            Sign out
          </button>
        ) : (
          <button onClick={() => setIsSignedIn(true)}>
            Sign in
          </button>
        )}
        <p ref={paraRef}>This is a paragraph</p>
      <button onClick={changeColor}>Change Color</button>
      <CountRender />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/product" element={<Product />} />
          <Route
            path="/dashboard"
            element={
              <Protected isSignedIn={isSignedIn}>
                <Dashboard />
              </Protected>
            }
          />
          <Route
            path="/markdown"
            element={<MarkdownEditor />}
          />
          <Route path="/component1" element={<Component1 />} />
        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App



