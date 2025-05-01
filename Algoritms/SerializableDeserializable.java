package Algoritms;

import java.io.*;

class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String position;
    private final double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void serialize(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Employee deserialize(String filename) {
        Employee employee = null;
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename))) {
            employee = (Employee) ios.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return employee;
    }
}

public class SerializableDeserializable {
    public static void main(String[] args) {
        Employee employee = new Employee("Anna", "Menager", 1000);
        employee.serialize("Algoritms\\SaveObject.ser");

        Employee deserializable = employee.deserialize("Algoritms\\SaveObject.ser");
        System.out.println(deserializable.getName());
        System.out.println(deserializable.getPosition());
        System.out.println(deserializable.getSalary());
    }
}
