public class Rectangle {
    private float width = 1.0f;
    private float length = 1.0f;

    //constructor
    public Rectangle(){

    }
    public Rectangle(float width, float length){
        this.width = width;
        this.length = length;
    }
    //setters and getters
    public float getWidth(){
        return width;
    }
    public float getLength(){
        return length;
    }
    public void setWidth(float width){
        this.width = width;
    }
    public void setLength(float length){
        this.length = length;
    }

    // getArea
    public float getArea(){
        return width*length;
    }
    // getPerimeter
    public float getPerimeter(){
        return (width+length)*2;
    }
    // override toString method
    @Override
    public String toString(){
        return "Rectangle(width:"+width+", length:"+length+", area:"+this.getArea()+", perimeter:"+this.getPerimeter()+")";
    }


    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setLength(10);
        rect.setWidth(20);
        System.out.println("Area: "+rect.getArea());
        System.out.println("Perimeter: "+rect.getPerimeter());
        System.out.println(rect.toString());
    }

}
