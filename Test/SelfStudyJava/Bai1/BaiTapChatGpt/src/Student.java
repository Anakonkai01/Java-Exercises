import java.util.ArrayList;
import java.util.List;

public class Student{
    private String name;
    private String ID;
    private List<Course> CourseList;
    public Student(String name, String iD) {
        this.name = name;
        this.ID = iD;
        CourseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }


    class Course{
        private String courseName;
        private double score;
        public Course(){
            this.courseName = "";
            this.score = -1;
        }
        public Course(String courseName, double score) {
            this.courseName = courseName;
            this.score = score;
        }
        public String getCourseName() {
            return courseName;
        }
        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
        public double getScore() {
            return score;
        }
        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "courseName='" + courseName + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public void addCourse(String courseName, double score) {
        CourseList.add(new Course(courseName, score));
    }

    public void removeCourse(String courseName) {
        CourseList.removeIf(c -> c.getCourseName().equals(courseName));
    }

    public double caculateGPA() {
        double GPA = 0;
        for(Course c : CourseList){
            if(c.getScore() > 5) {
                GPA += c.getScore();
            }
        }
        GPA = GPA / CourseList.size();
        return GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", CourseList=" + CourseList +
                '}';
    }
}