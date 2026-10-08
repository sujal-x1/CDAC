import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import React from "react";
import Header from './component/header'
import Employee from './component/employee'

function App() {
  return (
    <div>
        <h1>Sujal</h1>
      <Header />

      <Employee
        name="Vita 8"
        salary="50000"
        dept="Placement"
        head="Pooja"
      />
    </div>
  );
}

export default App;