package exercise2;


public class Square extends Rectangle{
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