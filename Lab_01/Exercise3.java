public class Exercise3 {
    public static int remainder(int a, int b){
        return a%b;
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        System.out.printf("the remainder of %d/%d = %d",a,b,remainder(a, b));
    }
}
