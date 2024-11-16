package exercise2;

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
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Shape other = (Shape) obj;
        if((getArea() != other.getArea())) return false;
        return true;
    }
    
    // abtract method
    abstract public double getArea();
    abstract public double getPerimeter();
    abstract public String toString();
}
