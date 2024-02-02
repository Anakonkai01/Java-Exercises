public class Exercise8 {
    public static int a(int n){
        return (n <= 1)? 1 : n+a(n-1);
    }

    public static int b(int n){
        return (n <= 1)? 1 : n*b(n-1);
    }

    public static int c(int n){
        return (n < 0)? 0 : (int)Math.pow(2,n) + c(n-1);
    }

    public static double d(int n){
        return (n <= 0) ? 0.0 : 1.0 / (2 * n) + d(n - 1);
    }

    public static int e(int n){
        return (n <= 1) ? 1 : n*n + e(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("a = "+a(n));
        System.out.println("b = "+b(n));
        System.out.println("c = "+c(n));
        System.out.println("d = "+d(n));
        System.out.println("e = "+e(n));
    }
}
