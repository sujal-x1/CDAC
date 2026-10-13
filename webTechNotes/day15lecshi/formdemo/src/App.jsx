import { useState } from 'react'
import MyForm from './Myform'
import DynamicRadio from './dynamicRadio'
import Hobby from './Hobby'
export default function App(){
  return(<>
    <MyForm />
    <br></br>
    <DynamicRadio />
        <br></br>
        <br></br>
        <Hobby />

  </>)
}