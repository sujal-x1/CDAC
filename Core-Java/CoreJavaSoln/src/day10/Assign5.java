package day10;

import java.io.Serializable;

public class Assign5 implements Serializable {
	private int num;
	Assign5(int num){
		this.num = num;
	}
	@Override
	public String toString() {
		return "[num=" + num + "]";
	}
}
