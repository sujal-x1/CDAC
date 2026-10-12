import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import App from "./App.jsx";
import Home from "./Home.jsx";
import Contact from "./Contactus.jsx";
import Listperson from "./ListPerson.jsx";
import CreateEmployee from "./CreateEmployee.jsx";
import NotFound from "./Notfound.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>
          <Route path="Home" element={<Home />} />
          <Route path="Contactus" element={<Contact />} />
          <Route path="Listperson" element={<Listperson />} />
          <Route path="CreateEmployee" element={<CreateEmployee />} />
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>
);