// Shape.java
abstract class Shape {
    protected String color;
    public Shape() {
        this.color = "";
    }
    public Shape(String color) {
        this.color = color;
    }
    public abstract double getArea();
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}



// Rectangle.java
class Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle() {
        super();
        this.length = 0;
        this.width = 0;
    }
    public Rectangle(double length, double width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {
        return this. length * this.width;
    }
    public double getPerimeter() {
        return (this.length + this.width) * 2.0;
    }
    public String toString() {
        return "Rectangle{" + "length=" + length +
        ", width=" + width +
        ", color=" + color + '}';
    }
}
   
class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(){

    }
    public Triangle( String color,double base, double height){
        this.color = color;
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return height*base;
    }
    @Override
    public String toString() {
        return "Triangle [base=" + base + ", height=" + height + "]";
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Triangle t1 = new Triangle("Red",10,20);
        Rectangle r1 = new Rectangle(10,20,"Blue");
        System.err.println(r1.color);
        System.out.println(t1.color);
    }
}
