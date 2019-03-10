package com.sigalhu.je.java.clazz;

/**
 * @author sigalhu
 */
public class ObjectClone {

    public static void main(String[] args) {
        Professor p1 = new Professor();
        p1.setName("Professor Zhang");
        p1.setAge(30);

        Student s1 = new Student();
        s1.setName("xiao ming");
        s1.setAge(18);
        s1.setProfessor(p1);

        System.out.println(s1);

        try {
            Student s2 = (Student) s1.clone();
            Professor p2 = s2.getProfessor();
            p2.setName("Professor Li");
            p2.setAge(45);
            s2.setProfessor(p2);
            System.out.println("深拷贝后的：s1 = " + s1);
            System.out.println("深拷贝后的：s2 = " + s2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

class Student implements Cloneable {

    private String name;

    private int age;

    private Professor professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", professor="
                + professor + "]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.professor = (Professor) student.professor.clone();
        return student;
    }
}

class Professor implements Cloneable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Professor [name=" + name + ", age=" + age + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}