public class Exercise6 {
    public static int findMinimum(int a, int b, int c) {
        return Math.min(Math.min(a, b),c);
    }

    public static void main(String[] args) {
        int a = 15;
        int b = 8;
        int c = 23;

        int minimum = findMinimum(a, b, c);

        System.out.printf("The minimum among %d, %d, %d is: %d.",a,b,c,minimum);
    }
}
