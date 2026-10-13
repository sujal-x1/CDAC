import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import App from "./App.jsx";
import Home from "./Home.jsx";
import Contact from "./Contactus.jsx";
import Listperson from "./ListPerson.jsx";
import CreateEmployee from "./Createemp.jsx";
import Employeeup from "./Updateemp.jsx";
import NotFound from "./notfound.jsx";
import Search from "./Search.jsx";
import SearchData from "./Container.jsx";
import Protected from "./ProtectedRoute.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>
          <Route index element={<Home />} />
          <Route path="Home" element={<Home />} />
          <Route path="Contactus" element={<Contact />} />

          <Route
            path="Listperson"
            element={
              <Protected>
                <Listperson />
              </Protected>
            }
          />
          <Route path="CreateEmployee" element={<CreateEmployee />} />
          <Route path="empup/:id" element={<Employeeup />} />
          <Route path="Search" element={<Search />} />
          <Route path="SearchData" element={<SearchData />} />
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>
);