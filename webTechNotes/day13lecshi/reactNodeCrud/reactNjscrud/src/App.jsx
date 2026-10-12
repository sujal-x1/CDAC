import { Outlet, Link } from "react-router-dom";
import Header from "./header";
import Footer from "./footer";

function App() {
  return (
    <>
      <header>
      </header>
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
        </ul>
      </nav>

      <main>
        <Outlet />
      </main>
<Footer/>
      <footer>

      </footer>
    </>
  );
}
export default App;

