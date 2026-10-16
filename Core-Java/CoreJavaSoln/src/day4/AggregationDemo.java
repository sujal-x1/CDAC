package day4;

class Teacher{
	private String name;
	private int age;
	public Teacher(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		 return name;
	}
	public void setName(String name) {
		 this.name= name;
	}
	public int getAge() {
		 return age;
	}
	public void setAge(int age) {
	    this.age = age;
	}
	public  void work() {
		System.out.println("Teacher is working");
	}
}

class dept{
	private Teacher teacher;
	private String dname;
	public dept(String dname) {
		teacher=null;
		this.dname=dname;
	}
	public String getDname() {
		return dname;
	}
	public void addTeacher(Teacher teacher) {
		this.teacher=teacher;
	}
	public void perform() {
		System.out.println(dname+"\t");
		teacher.work();
	}
	public String getTeqcher() {
		return teacher.getName();
	}
}

public class AggregationDemo {
	public static void main(String[] args) {
		dept sd=new dept("Science Department");
		dept md=new dept("Maths Department");
		System.out.println(sd.getDname());
		System.out.println(md.getDname());
		Teacher t1=new Teacher("Abc",35);
		System.out.println(t1.getName()+"\t"+t1.getAge());
		md.addTeacher(t1);
		md.perform();
		System.out.println("Lets close the maths department");
		md=null;  // delete maths department
		System.out.println(t1.getName()+" still exists and can join some other department");
		sd.addTeacher(t1);
		sd.perform();
		// ..... after some time ......
		t1=null;  //delete science department
//		System.out.println(t1.getName()+" still exists and can join some other department");
		System.out.println(sd.getTeqcher());
		
	}
}




