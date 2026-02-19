package app;
import model.Student;
import service.StudentService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==Student Management System==");

        while(true){
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Remove Student by ID");
            System.out.println("4. Show Students above marks");
            System.out.println("5. Sort Students by Marks");
            System.out.println("0. Exit");
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();

            if(choice==0){
                System.out.println("Exiting...");
                break;
            }
            switch(choice){
                case 1 ->{
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); //consumes next line

                    System.out.println("Enter name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter Marks:");
                    double marks = scanner.nextDouble();

                    service.addStudent(new Student(id,name,marks));
                    System.out.println("Student added successfully!");
                }
                case 2 -> {
                    service.getAllStudents().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Enter ID to remove:");
                    int id = scanner.nextInt();
                    service.removeStudentById(id);
                    System.out.println("Student removed (if existed)");
                }
                case 4 ->{
                    System.out.println("Enter minimum marks:");
                    double marks = scanner.nextDouble();
                    service.getStudentAboveMarks(marks).forEach(System.out::println);
                    //ForEach method runs some action on every element, one by one.
                    //System.out::println is a method reference, which is a shorter form of lambda expression
                    //System.out::println means 'For each element, pass it to System.out.println'
                }
                case 5 ->{
                    service.sortByMarks().forEach(System.out::println);
                }
                default ->{
                    System.out.println("Invalid Option, Try again.");
                }
            }
        }
    }
}
