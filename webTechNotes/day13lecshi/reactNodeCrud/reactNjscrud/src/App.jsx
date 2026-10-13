import { Outlet, Link } from "react-router-dom";
import Header from "./Header.jsx";
import Footer from "./Footer.jsx";
import { useState } from "react";

function App() {
  const [isSignedIn, setIsSignedIn] = useState(false);

  const signin = () => setIsSignedIn(true);
  const signout = () => setIsSignedIn(false);

  return (
    <>
      <Header />
      <nav>
        <ul>
          <li>
            <Link to="/Home">Home</Link>
          </li>
          <li>
            <Link to="/Contactus">Contact</Link>
          </li>
          <li>
            <Link to="/Listperson">List Person</Link>
          </li>
          <li>
            <Link to="/CreateEmployee">Create Employee</Link>
          </li>
          <li>
            <Link to="/Listperson">Edit Employee</Link>
          </li>
          <li>
            <Link to="/Search">Search Employee</Link>
          </li>
          <li>
            <Link to="/SearchData">SearchData</Link>
          </li>
        </ul>
      </nav>
      {isSignedIn ? (
        <button onClick={signout}>Sign out</button>
      ) : (
        <button onClick={signin}>Sign in</button>
      )}
      <main>
        <Outlet context={{ isSignedIn }} />
      </main>
      <Footer />
    </>
  );
}
export default App;
