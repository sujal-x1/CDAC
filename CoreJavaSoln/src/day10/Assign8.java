package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class Assign8 implements Serializable {

    int id;
    String name;

    Assign8(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    public static void main(String args[]) {

        // Create 5 different objects
        Assign8 obj1 = new Assign8(1, "Phone");
        Assign8 obj2 = new Assign8(2, "Laptop");
        Assign8 obj3 = new Assign8(3, "Headphones");
        Assign8 obj4 = new Assign8(4, "Keyboard");
        Assign8 obj5 = new Assign8(5, "Mouse");

        // Add objects to ArrayList
        ArrayList<Assign8> list = new ArrayList<>();

        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        list.add(obj5);

        try {

            // Store ArrayList in file
            FileOutputStream fos = new FileOutputStream("Assign8.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);

            oos.close();

            // Read ArrayList from file
            FileInputStream fis = new FileInputStream("Assign8.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Assign8> list2 =
                    (ArrayList<Assign8>) ois.readObject();

            // Display all objects using ListIterator
            ListIterator<Assign8> itr = list2.listIterator();

            while (itr.hasNext()) {
                Assign8 obj = itr.next();
                obj.displayDetails();
            }

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
