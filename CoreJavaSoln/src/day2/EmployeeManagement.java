package day2;

public class EmployeeManagement {
		private int id;
		private String name;
		private int salary;
		static private String CompanyName="jj";
		static private int employeeCount; 
		
		EmployeeManagement(int id,String name,int salary){
			this.id=id;
			this.name=name;
			this.salary=salary;
			employeeCount++;
		}
		
		static void DisplayCount(){
			System.out.println(employeeCount);
		}
		
		 void empDetails(){
			System.out.println(name+" "+CompanyName+" "+salary);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EmployeeManagement e1= new EmployeeManagement(1,"sujal",99999);
		 EmployeeManagement e2= new EmployeeManagement(2,"gole",0);
		 EmployeeManagement e3= new EmployeeManagement(3,"jesus",43);

		 DisplayCount();
		 e1.empDetails();
		 e2.empDetails();
		 e3.empDetails();
	}

}
