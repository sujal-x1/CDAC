// src/App.tsx
import React from "react";
import { Outlet, Link } from "react-router-dom";

// Explicitly type the component as React.FC (React Function Component)
const App: React.FC = () => {
  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/Home">Home</Link>
          </li>
          <li>
            <Link to="/Contactus">Contactus</Link>
          </li>
          <li>
            <Link to="/Listemployee">Listemployee</Link>
          </li>
        </ul>
      </nav>

      {/* Outlet is typed automatically by react-router-dom */}
      <Outlet />
    </div>
  );
};

export default App;
