package exercise4;

class ResizeableCircle extends Circle implements Resizable{
    //constructor
    public ResizeableCircle(){
        super();
    }
    @Override
    public void resize(int percent) {
        this.radius = this.radius*percent/100;
    }
}