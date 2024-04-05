package exercise2;

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