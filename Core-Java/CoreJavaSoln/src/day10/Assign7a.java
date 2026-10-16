package day10;

import java.io.Serializable;

public class Assign7a implements Product,Serializable{//Electronics;
int price;
String name;

Assign7a(int price,String name){
	this.name=name;
	this.price=price;
}
	@Override
	public void displayDetails() {
		System.out.println("name="+name+"\t price="+price);
	}

	
}