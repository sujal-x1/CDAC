import { Savingaccount } from "./Saving.mjs";
const sobj=new Savingaccount("sav","raj","Mathur",5000);
console.log(sobj.toString());
sobj.withdraw(1000);
console.log(sobj);
