package exercise1;

public class Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle() {
        super();
        this.length = 0;
        this.width = 0;
    }
    public Rectangle(double length, double width) {
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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectangle other = (Rectangle) obj;
        if (length != other.length)
            return false;
        if (width != other.width)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rectangle[" + "length=" + length +
        ", width=" + width + "]";
    }
}