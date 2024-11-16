package exercise4;

public class Circle implements GeometricObject{
    protected double radius;
    
    // constructor
    public Circle (){

    }
    public Circle (double radius){
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
    
}