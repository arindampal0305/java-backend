package service;
import model.Student;
import java.util.List;
import java.util.ArrayList;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    public boolean addStudent(Student s){
        if(isIdExists(s.getId())){
            return false;
        }
        students.add(s);
        return true;
    }
    public void removeStudentById(int id){
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getAllStudents(){
        return students;
    }
    public List<Student> getStudentAboveMarks(double marks){
        return students.stream().filter(student -> student.getMarks() > marks).toList();
    }
    public List<Student> sortByMarks(){
        return students.stream().sorted((s1,s2)-> Double.compare(s1.getMarks(), s2.getMarks())).toList();
    }
    private boolean isIdExists(int id){
        return students.stream().anyMatch(student -> student.getId() == id);
    }

}
