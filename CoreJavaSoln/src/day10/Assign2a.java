package day10;
/*
 * on the developer side:
	create a generic class which can accept any type
		with setters , getters and toString methods.
	create necessary jar files and  documentation.

on client side 
	create the object of above generic class and invoke its setters , getters and display the object.
 */
public class Assign2a <T>{
	private T name;
	private T age;
	public T getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Assign2a [name=" + name + ", age=" + age + "]";
	}
	public void setName(T name) {
		this.name = name;
	}
	public T getAge() {
		return age;
	}
	public void setAge(T age) {
		this.age = age;
	}
	
}
