package exercise1;

public class Main {
    public static void main(String[] args) {
        Triangle t1 = new Triangle(10,20);
        Triangle t2 = new Triangle(10,20);
        Rectangle r1 = new Rectangle(10,20);
        Rectangle r2 = new Rectangle(10,221);
        System.out.println(t1.equals(t2));
        System.out.println(r1.equals(r2));
    }
}
