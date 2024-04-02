abstract class Shape{
    protected String color;
    protected boolean filled;

    //constructor
    public Shape(){

    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    //getter and setter
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Shape other = (Shape) obj;
        if((getArea() != other.getArea())) return false;
        return true;
    }
    
    // abtract method
    abstract public double getArea();
    abstract public double getPerimeter();
    abstract public String toString();
}


class Circle extends Shape{
    private double radius;

    // constructor
    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius,String color, boolean filled){
        super(color,filled);
        this.radius = radius;

    }

    //getter and setter
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
    @Override
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}

class Rectangle extends Shape{
    protected double witdh;
    protected double length;

    //constructor
    public Rectangle(){

    }
    public Rectangle(double witdh, double length, String color, boolean filled) {
        super(color, filled);
        this.witdh = witdh;
        this.length = length;
    }
    
    // getter and setter
    public double getWitdh() {
        return witdh;
    }
    public double getLength() {
        return length;
    }
    public void setWitdh(double witdh) {
        this.witdh = witdh;
    }
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return witdh*length;
    }
    @Override
    public double getPerimeter() {
        return (witdh+length)*2;
    }
    @Override
    public String toString() {
        return "Rectangle [witdh=" + witdh + ", length=" + length + "]";
    }   
}


class Square extends Rectangle{
    // constructor
    public Square(){

    }
    public Square(double side,String color,boolean filled){
        super(side,side,color,filled);
    }

    // getter and setter
    public double getSide(){
        return witdh;
    }
    public void setSide(double side){
        this.witdh = side;
        this.length = side;
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }
    @Override
    public void setWitdh(double witdh) {
        super.setWitdh(witdh);
    }
}
public class Exercise2 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(4, "Red", true);
        shapes[1] = new Circle(4, "Blue", false);
        shapes[2] = new Square(10, "Black", true);
        shapes[3] = new Circle(9);
        shapes[4] = new Rectangle(12, 8, "Blue", true);
        
        for(Shape s : shapes){
            System.out.println(s.getArea());
        }

        double max = shapes[0].getArea();
        for(Shape s : shapes){
            if(max < s.getArea()){
                max = s.getArea();
            }
        }
        System.out.println(max);
        System.out.println(shapes[0].equals(shapes[1]));
    }
}
