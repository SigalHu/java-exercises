package com.sigalhu.je.java.clazz;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author sigalhu
 */
public class ObjectConstruct {

    public static void main(String... args) throws Exception {
        // By using new keyword
        Employee emp1 = new Employee();
        emp1.setName("Naresh");
        System.out.println(emp1 + ", hashcode : " + emp1.hashCode());

        // By using Class class's newInstance() method
        Employee emp2 = (Employee) Class.forName("com.sigalhu.je.java.clazz.Employee")
                .newInstance();
        // Or we can simply do this
        // Employee emp2 = Employee.class.newInstance();
        emp2.setName("Rishi");
        System.out.println(emp2 + ", hashcode : " + emp2.hashCode());

        // By using Constructor class's newInstance() method
        Constructor<Employee> constructor = Employee.class.getConstructor();
        Employee emp3 = constructor.newInstance();
        emp3.setName("Yogesh");
        System.out.println(emp3 + ", hashcode : " + emp3.hashCode());

        // By using clone() method
        Employee emp4 = (Employee) emp3.clone();
        emp4.setName("Atul");
        System.out.println(emp4 + ", hashcode : " + emp4.hashCode());

        // By using Deserialization
        PipedOutputStream pipedOut = new PipedOutputStream();
        PipedInputStream pipedIn = new PipedInputStream();
        pipedIn.connect(pipedOut);

        // Serialization
        ObjectOutputStream out = new ObjectOutputStream(pipedOut);
        out.writeObject(emp4);
        //Deserialization
        ObjectInputStream in = new ObjectInputStream(pipedIn);
        Employee emp5 = (Employee) in.readObject();

        pipedOut.close();
        pipedIn.close();
        out.close();
        in.close();

        emp5.setName("Akash");
        System.out.println(emp5 + ", hashcode : " + emp5.hashCode());
    }
}

class Employee implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public Employee() {
        System.out.println("Employee Constructor Called...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + "]";
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
