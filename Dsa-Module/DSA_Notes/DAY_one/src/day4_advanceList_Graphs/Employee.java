package day4_advanceList_Graphs;

//Employee ID, name, gender, salary.
//Setter, display, and constructor while we create an employee
public class Employee
{
 private int eid;
 private float salary;
 private String name,gender;
 Employee(int eid,String name,String gender,float salary)
 {
     this.eid=eid;
     this.name=name;
     this.gender=gender;
     this.salary=salary;
 }
 public void set_Employee(int eid,String name,String gender,float salary)
 {
     this.eid=eid;
     this.name=name;
     this.gender=gender;
     this.salary=salary;
 }
 public void display_employee()
 {
     System.out.println("\nID:"+eid+"\tName:"+name+"\tGender:"+gender+"\tSalary:"+salary);
 }
 int get_eid()
 {
     return eid;
 }
}
