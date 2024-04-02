interface GeometricObject{
    public double getArea();
    public double getPerimeter();
}

interface Resizable{
    public void resize(int percent);
}

class Circle implements GeometricObject{
    protected double radius;
    
    // constructor
    public Circle (){
        this.radius = 1;
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


class ResizeableCircle extends Circle implements Resizable{
    public ResizeableCircle(){
        
    }
    @Override
    public void resize(int percent) {
        this.radius = this.radius*percent/100;
    }
}


public class Exercise4 {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        ResizeableCircle c2 = new ResizeableCircle();
        c2.resize(120);
        System.out.println(c2.radius);
        System.out.println(c2.getArea());
    }
}
