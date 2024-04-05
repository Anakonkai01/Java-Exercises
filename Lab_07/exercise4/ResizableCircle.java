package exercise4;

class ResizeableCircle extends Circle implements Resizable{
    //constructor
    public ResizeableCircle(double radius){
        super(radius);
    }
    @Override
    public void resize(int percent) {
        this.radius = this.radius*percent/100;
    }
}