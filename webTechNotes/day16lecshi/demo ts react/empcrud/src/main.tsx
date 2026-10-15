// src/index.tsx
import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";

import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./Home";
import Listemployee from "./ListEmployee";
import Contactus from "./ContactUs";
import Employee from "./Employee";
import Nopage from "./NoPage";
import Createemp from "./Createemp";
import Employeedel from "./Employeedel";
import Employeeup from "./Employeeup";

// Ensure root element is not null
const rootElement = document.getElementById("root");
if (!rootElement) {
  throw new Error("Root element not found");
}

const root = ReactDOM.createRoot(rootElement);

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>
          <Route index element={<Home />} />
          <Route path="Home" element={<Home />} />
          <Route path="Contactus" element={<Contactus />} />
          <Route path="Listemployee" element={<Listemployee />} />
         <Route path="empdel/:id" element={<Employeedel />} />
          <Route path="Create" element={<Createemp />} />
           <Route path="emp/:id" element={<Employee />} />  
          <Route path="empup/:id" element={<Employeeup />} />
       
          <Route path="*" element={<Nopage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

// Performance reporting

