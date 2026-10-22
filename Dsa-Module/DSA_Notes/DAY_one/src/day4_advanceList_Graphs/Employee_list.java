package day4_advanceList_Graphs;

import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Employee_list
{
    static LinkedList<Employee> list = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    // Register a new employee
    static void register_employee()
    {
        System.out.print("Enter Employee ID: ");
        int eid = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        if (search_index(eid) != -1)
        {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Salary: ");
        float salary = sc.nextFloat();

        Employee e = new Employee(eid, name, gender, salary);
        list.add(e);

        System.out.println("Employee registered successfully!");
    }

    // Return the index of an employee, or -1 if not found
    static int search_index(int eid)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).get_eid() == eid)
            {
                return i;
            }
        }

        return -1;
    }

    // Search for an employee
    static void search_employee()
    {
        System.out.print("Enter Employee ID to search: ");
        int eid = sc.nextInt();

        int index = search_index(eid);

        if (index != -1)
        {
            System.out.println("\nEmployee Found:");
            list.get(index).display_employee();
        }
        else
        {
            System.out.println("Employee not found!");
        }
    }

    // Delete employee by ID
    static void delete_employee()
    {
        System.out.print("Enter Employee ID to delete: ");
        int eid = sc.nextInt();

        int index = search_index(eid);

        if (index != -1)
        {
            list.remove(index);
            System.out.println("Employee deleted successfully!");
        }
        else
        {
            System.out.println("Employee not found!");
        }
    }

    // Display all employees
    static void list_employees()
    {
        if (list.isEmpty())
        {
            System.out.println("No employees registered.");
            return;
        }

        System.out.println("\n========== EMPLOYEE LIST ==========");

        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).display_employee();
        }
    }

    // Update employee details
    static void update_employee()
    {
        System.out.print("Enter Employee ID to update: ");
        int eid = sc.nextInt();

        int index = search_index(eid);

        if (index != -1)
        {
            Employee e = list.get(index);

            System.out.println("Existing Details:");
            e.display_employee();

            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Gender: ");
            String gender = sc.nextLine();

            System.out.print("Enter New Salary: ");
            float salary = sc.nextFloat();

            e.set_Employee(eid, name, gender, salary);

            System.out.println("Employee updated successfully!");
        }
        else
        {
            System.out.println("Employee not found!");
        }
    }

    // Main menu
    public static void main(String[] args)
    {
        int choice;

        do
        {
            System.out.println("\n========== EMPLOYEE MANAGEMENT ==========");
            System.out.println("1. Register Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. List All Employees");
            System.out.println("5. Update Employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    register_employee();
                    break;

                case 2:
                    search_employee();
                    break;

                case 3:
                    delete_employee();
                    break;

                case 4:
                    list_employees();
                    break;

                case 5:
                    update_employee();
                    break;

                case 0:
                    System.out.println("Exiting Employee Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
