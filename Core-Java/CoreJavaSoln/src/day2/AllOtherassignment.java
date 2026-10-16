package day2;
/*
public class AllOtherassignment {
	// Assignment 4 - Product Inventory
	class Product {

	    private int productId;
	    private String productName;
	    private double price;
	    private int quantity;

	    private static String storeName = "Reliance Store";

	    Product(int productId, String productName, double price, int quantity) {
	        this.productId = productId;
	        this.productName = productName;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    double calculateTotalValue() {
	        return price * quantity;
	    }

	    static void changeStoreName(String newName) {
	        storeName = newName;
	    }

	    void displayDetails() {
	        System.out.println("Product ID   : " + productId);
	        System.out.println("Product Name : " + productName);
	        System.out.println("Price        : " + price);
	        System.out.println("Quantity     : " + quantity);
	        System.out.println("Total Value  : " + calculateTotalValue());
	        System.out.println("Store Name   : " + storeName);
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        Product p1 = new Product(101, "Laptop", 50000, 2);
	        Product p2 = new Product(102, "Mouse", 500, 10);
	        Product p3 = new Product(103, "Keyboard", 1000, 5);

	        p1.displayDetails();
	        p2.displayDetails();
	        p3.displayDetails();

	        Product.changeStoreName("Amazon Store");

	        p1.displayDetails();
	    }
	}


	// Assignment 5 - Car Showroom
	class Car {

	    private String brand;
	    private String model;
	    private double price;

	    private static String showroomName = "ABC Motors";

	    Car(String brand, String model, double price) {
	        this.brand = brand;
	        this.model = model;
	        this.price = price;
	    }

	    static void changeShowroomName(String newName) {
	        showroomName = newName;
	    }

	    void displayDetails() {
	        System.out.println("Brand  : " + brand);
	        System.out.println("Model   : " + model);
	        System.out.println("Price  : " + price);
	        System.out.println("Showroom : " + showroomName);
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        Car c1 = new Car("Toyota", "Fortuner", 4000000);
	        Car c2 = new Car("Honda", "City", 1500000);
	        Car c3 = new Car("BMW", "X5", 8000000);
	        Car c4 = new Car("Tata", "Nexon", 1200000);

	        c1.displayDetails();
	        c2.displayDetails();
	        c3.displayDetails();
	        c4.displayDetails();

	        Car.changeShowroomName("XYZ Motors");

	        c1.displayDetails();
	    }
	}


	// Assignment 6 - Library Book
	class Book {

	    private int bookId;
	    private String title;
	    private String author;
	    private double price;

	    private static String libraryName = "City Library";
	    private static int bookCount = 0;

	    Book(int bookId, String title, String author, double price) {
	        this.bookId = bookId;
	        this.title = title;
	        this.author = author;
	        this.price = price;

	        bookCount++;
	    }

	    static void displayBookCount() {
	        System.out.println("Total books created: " + bookCount);
	    }

	    void displayDetails() {
	        System.out.println("Book ID      : " + bookId);
	        System.out.println("Title        : " + title);
	        System.out.println("Author       : " + author);
	        System.out.println("Price        : " + price);
	        System.out.println("Library      : " + libraryName);
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        Book b1 = new Book(1, "Java Basics", "James", 500);
	        Book b2 = new Book(2, "Python Basics", "John", 600);
	        Book b3 = new Book(3, "C++ Programming", "Robert", 700);
	        Book b4 = new Book(4, "Data Structures", "Mark", 800);

	        b1.displayDetails();
	        b2.displayDetails();
	        b3.displayDetails();
	        b4.displayDetails();

	        Book.displayBookCount();
	    }
	}


	// Assignment 7 - Hospital Patient
	class Patient {

	    private int patientId;
	    private String name;
	    private String disease;
	    private int age;

	    private static String hospitalName = "Apollo Hospital";

	    Patient(int patientId, String name, String disease, int age) {
	        this.patientId = patientId;
	        this.name = name;
	        this.disease = disease;
	        this.age = age;
	    }

	    static void updateHospitalName(String newName) {
	        hospitalName = newName;
	    }

	    void displayDetails() {
	        System.out.println("Patient ID   : " + patientId);
	        System.out.println("Name         : " + name);
	        System.out.println("Disease      : " + disease);
	        System.out.println("Age          : " + age);
	        System.out.println("Hospital     : " + hospitalName);
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        Patient p1 = new Patient(101, "Rahul", "Fever", 25);
	        Patient p2 = new Patient(102, "Amit", "Cold", 30);
	        Patient p3 = new Patient(103, "Priya", "Diabetes", 45);
	        Patient p4 = new Patient(104, "Neha", "Cough", 28);
	        Patient p5 = new Patient(105, "Ravi", "Headache", 35);

	        p1.displayDetails();
	        p2.displayDetails();
	        p3.displayDetails();
	        p4.displayDetails();
	        p5.displayDetails();

	        Patient.updateHospitalName("Max Hospital");

	        p1.displayDetails();
	    }
	}


	// Assignment 9 - University Course
	class Course {

	    private int courseId;
	    private String courseName;
	    private int duration;

	    private static String universityName = "Delhi University";

	    Course(int courseId, String courseName, int duration) {
	        this.courseId = courseId;
	        this.courseName = courseName;
	        this.duration = duration;
	    }

	    static void changeUniversityName(String newName) {
	        universityName = newName;
	    }

	    void displayDetails() {
	        System.out.println("Course ID    : " + courseId);
	        System.out.println("Course Name  : " + courseName);
	        System.out.println("Duration     : " + duration + " years");
	        System.out.println("University   : " + universityName);
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        Course c1 = new Course(1, "Java", 2);
	        Course c2 = new Course(2, "Python", 2);
	        Course c3 = new Course(3, "Data Science", 3);

	        c1.displayDetails();
	        c2.displayDetails();
	        c3.displayDetails();

	        Course.changeUniversityName("Mumbai University");

	        c1.displayDetails();
	    }
	}


	// Assignment 10 - Electricity Bill
	public class ElectricityBill {

	    private int consumerId;
	    private String consumerName;
	    private double unitsConsumed;

	    private static double costPerUnit = 8.0;

	    ElectricityBill(int consumerId, String consumerName, double unitsConsumed) {
	        this.consumerId = consumerId;
	        this.consumerName = consumerName;
	        this.unitsConsumed = unitsConsumed;
	    }

	    static void changeCostPerUnit(double newCost) {
	        costPerUnit = newCost;
	    }

	    double calculateTotalBill() {
	        return unitsConsumed * costPerUnit;
	    }

	    void displayDetails() {
	        System.out.println("Consumer ID   : " + consumerId);
	        System.out.println("Consumer Name : " + consumerName);
	        System.out.println("Units Used    : " + unitsConsumed);
	        System.out.println("Cost Per Unit : " + costPerUnit);
	        System.out.println("Total Bill    : " + calculateTotalBill());
	        System.out.println();
	    }

	    public static void main(String[] args) {

	        ElectricityBill e1 =
	                new ElectricityBill(1, "Sujal", 100);

	        ElectricityBill e2 =
	                new ElectricityBill(2, "Rahul", 250);

	        ElectricityBill e3 =
	                new ElectricityBill(3, "Amit", 500);

	        e1.displayDetails();
	        e2.displayDetails();
	        e3.displayDetails();

	        ElectricityBill.changeCostPerUnit(10);

	        e1.displayDetails();
	        e2.displayDetails();
	        e3.displayDetails();
	    }
	}

}
*/