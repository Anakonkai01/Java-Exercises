package Bai1;

import java.util.ArrayList;
import java.util.List;

public class Course implements Enrollable{
    private String courseName;
    private List<Student> enrolledStudent;
    private List<Teacher> teacher;

    public Course(String courseName){
        this.courseName = courseName;
        this.enrolledStudent = new ArrayList<>();
        this.teacher = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student){
        this.enrolledStudent.add(student);
    }

    public void addTeacher(Teacher teacher){
        this.teacher.add(teacher);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", enrolledStudent=" + enrolledStudent +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public void enrol(){

    }
}
