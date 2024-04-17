package exercise3;


abstract public class Student {
    private String sName;
    private double gpa;

    public Student(){

    }

    public Student(String sName, double gpa) {
        this.sName = sName;
        this.gpa = gpa;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    abstract public String getRank();

    @Override
    public String toString() {
        return "Student{" +
                "sName='" + sName + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}


