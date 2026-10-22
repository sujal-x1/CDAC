package day4_advanceList_Graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class Employee_menudriven {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<Employee> list = new LinkedList<>();

        int choice, eid, index;
        String name, gender;
        float salary;

        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Update Employee");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Emp Id: ");
                    eid = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).get_eid() == eid) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("EID already exists");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Gender: ");
                    gender = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    salary = sc.nextFloat();

                    list.add(new Employee(eid, name, gender, salary));
                    System.out.println("Employee inserted successfully.");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).display_employee();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int key = sc.nextInt();

                    index = -1;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).get_eid() == key) {
                            index = i;
                            break;
                        }
                    }

                    if (index != -1) {
                        System.out.println("Employee found:");
                        list.get(index).display_employee();
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int del = sc.nextInt();

                    index = -1;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).get_eid() == del) {
                            index = i;
                            break;
                        }
                    }

                    if (index != -1) {
                        list.remove(index);
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to update: ");
                    int update = sc.nextInt();

                    index = -1;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).get_eid() == update) {
                            index = i;
                            break;
                        }
                    }

                    if (index != -1) {
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        name = sc.nextLine();

                        System.out.print("Enter New Gender: ");
                        gender = sc.nextLine();

                        System.out.print("Enter New Salary: ");
                        salary = sc.nextFloat();

                        list.get(index).set_employee(
                            update, name, gender, salary
                        );

                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
