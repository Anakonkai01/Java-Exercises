public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Nhan","523H0164");
        st1.addCourse("Triet hoc",9);
        st1.addCourse("Phap Luat",8);
        st1.removeCourse("Phap Luat");
        System.out.println(st1);
    }
}
