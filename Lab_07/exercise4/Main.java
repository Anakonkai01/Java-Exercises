package exercise4;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        ResizeableCircle c2 = new ResizeableCircle(10);
        c2.resize(120);
        System.out.println(c1.radius);
        System.out.println(c1.getArea());
        System.out.println(c2.radius);
        System.out.println(c2.getArea());
        System.out.println();
        System.out.println("double size of circle 2");
        c2.resize(200);
        System.out.println(c2.radius);
    }
}
