package Bai1;

public class Teacher extends Person {
    private String teacherID;
    public Teacher(){

    }
    public Teacher(String teacherID){
        this.teacherID = teacherID;
    }

    public String getTeacherID() {
        return teacherID;
    }
    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if(other == null || getClass() != other.getClass()) return false;
        Teacher teacher = (Teacher) other;
        return teacherID.equals(teacher.teacherID);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", teacherID='" + teacherID + '\'' +
                '}';
    }
}
