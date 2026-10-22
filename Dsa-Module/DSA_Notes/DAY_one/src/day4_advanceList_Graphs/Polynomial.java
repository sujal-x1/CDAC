package day4_advanceList_Graphs;

public class Polynomial {
	int power;
	float coefficient;
	
	Polynomial(float coefficient,int power){
		this.power = power;
		this.coefficient = coefficient;
	}
	
	void display() {
		System.out.println(coefficient + " x^" + power+"+");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
