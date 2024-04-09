package Bai1;

import java.util.Objects;

public class Student extends Person {
    private String studentID;
    public Student (){

    }
    public Student(String name,int age, String studentID) {
        super(name,age);
        this.studentID = studentID;
    }
    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if(other == null || getClass() != other.getClass()) return false;
        Student student = (Student) other;
        return studentID.equals(student.studentID);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
