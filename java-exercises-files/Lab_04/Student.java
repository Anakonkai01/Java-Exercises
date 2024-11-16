public class Student {
    private int id;
    private String firstName;
    private String lastName;

    //constructor
    public Student(int id,String firstName,String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //getters and setters
    public int getID() { 
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;    
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    @Override
    public String toString() {
        return "Student(ID: "+ id +", FirstName: " + firstName + ", LastName: " + lastName+")" ;
    }

    public static void main(String[] args) {
        Student student = new Student(123456,"Nhan","Hoang");
        System.out.println(student.toString());
    }
}
