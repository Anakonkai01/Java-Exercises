public class Exercise2 {
    public static double calTriangleArea(double a, double b){
        double area = (a*b)/2; 
        return area;
    }

    public static void main(String[] args) {
        int a = 10; 
        int b = 20;
        System.out.println(calTriangleArea(a,b));
    }
}
