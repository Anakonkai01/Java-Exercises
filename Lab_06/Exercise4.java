


class Shape{
    private String color;
    private boolean filled;
    public Shape(){
        this.color = "red";
        this.filled = true;
    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
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
    public String toString() {
        return "Shape [color=" + color + ", filled=" + filled + "]";
    }
}

class Circle extends Shape{
    private double radius;
    public Circle(){
        super();
        this.radius = 1.0;
    }
    public Circle(String color,boolean filled,double radius){
        super(color,filled);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    @Override
    public String toString() {
        return "Circle [color=" + super.getColor() + ", filled=" + super.isFilled() + ", radius=" + radius + ", area=" + getArea() + "]";
    }
}

class Rectangle extends Shape{
    private double width;
    private double length;
    public Rectangle(){
        super();
        this.width = 1.0;
        this.length = 1.0;
    }
    public Rectangle(String color,boolean filled,double width,double length){
        super(color,filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return 2*(width+length);
    }
    @Override
    public String toString() {
        return "Rectangle [color=" + super.getColor() + ", filled=" + super.isFilled() + ", width=" + width + ", length=" + length + ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
}

class Square extends Rectangle{
    public Square(){
        super();
    }
    public Square(String color,boolean filled,double side){
        super(color,filled,side,side);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }
    @Override
    public void setWidth(double width){
        super.setWidth(width);
    }
    @Override
    public void setLength(double length){
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "Square [color=" + super.getColor() + ", filled=" + super.isFilled() + ", side=" + getSide() + ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
}



public class Exercise4 {
    public static void main(String[] args) {
        
    }
}
