package exercise2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(4, "Red", true);
        shapes[1] = new Circle(4, "Blue", false);
        shapes[2] = new Square(10, "Black", true);
        shapes[3] = new Circle(9);
        shapes[4] = new Rectangle(12, 8, "Blue", true);
        
        System.out.println("Print area of each shape:");
        for(Shape s : shapes){
            System.out.println(s.getArea());
        }
        System.out.println();
        System.out.println("The largest area is:");
        double max = shapes[0].getArea();
        for(Shape s : shapes){
            if(max < s.getArea()){
                max = s.getArea();
            }
        }
        System.out.println(max);
        System.out.println();
        System.out.println("Compare the area of shapes 0 with the area of shapes 1");
        if(shapes[1].equals(shapes[0])){
            System.out.println("shapes[0] ==  shapes[1]");
        }
        else{
            System.out.println("Not equal");
        }
    }
}
