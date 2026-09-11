 package service;

import java.util.ArrayList;
import model.Student;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {

        if (findStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student findStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public boolean deleteStudent(int id) {

        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    public int getStudentCount() {
        return students.size();
    }
}