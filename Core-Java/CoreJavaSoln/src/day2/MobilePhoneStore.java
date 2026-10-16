package day2;

public class MobilePhoneStore {
	private String brand;
	private String model="hiko";
	private double price;
	static private String storeLocation="noida";
	
	void newStoreLocationn() {
		storeLocation="gujrat";
	}
	double setprice(double price) {
		this.price=price;
		return price;
	}
	double discount() {
		return price-=price*0.10;
	}
	
	String getbrand() {
		return brand;
	}
	
	void setBrand(String brand) {
	    this.brand = brand;
	}
	
	void alldetails() {
		System.out.println(brand);
		System.out.println(model);
		System.out.println(price);
		System.out.println(storeLocation);
	}

	public static void main(String[] args) {
		MobilePhoneStore m1= new MobilePhoneStore();
		m1.setBrand("nandu");
		System.out.println(m1.getbrand());
		m1.setprice(200);
		m1.discount();
		m1.alldetails();
	}
}
