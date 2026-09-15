package day10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Assign9 implements Serializable {

    int prn_no;
    String name;

    public static void main(String[] args) {

        HashMap<Integer, String> student = new HashMap<>();

        student.put(22, "Sujal");
        student.put(20, "Ujal");
        student.put(32, "Jal");
        student.put(23, "Al");
        student.put(24, "L");

        try {

            // Write HashMap into file
            FileOutputStream fos = new FileOutputStream("Assign9.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(student);

            oos.close();
            fos.close();

            // Read HashMap from file
            FileInputStream fis = new FileInputStream("Assign9.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<Integer, String> student2 =
                    (HashMap<Integer, String>) ois.readObject();

            ois.close();
            fis.close();

            // Display using Iterator
            Iterator<Map.Entry<Integer, String>> itr =
                    student2.entrySet().iterator();

            while (itr.hasNext()) {

                Map.Entry<Integer, String> entry = itr.next();

                System.out.println(
                        "PRN: " + entry.getKey()
                        + " Name: " + entry.getValue()
                );
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
