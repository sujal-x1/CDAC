package day10;

import java.io.Serializable;

public class Assign7b implements Product,Serializable {//Grocery
	int price;
	String name;
	Assign7b(int price,String name){
		this.price=price;
		this.name=name;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("name="+name+"\t price="+price);
	}

}
