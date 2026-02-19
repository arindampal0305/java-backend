package model;

public class Student {
    private int id;
    private String name;
    private double marks;
    //Fields are private to enforce Encapsulation.

    public Student(int id, String name, double marks)
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
        //Constructor
    }

    //Getters to allow fetching data after encapsulation:
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getMarks(){
        return marks;
    }
    @Override
    public String toString(){
        return "Student{" + "id=" + id +", name='" + name+'\''+", marks="+marks+'}';
    }

}
