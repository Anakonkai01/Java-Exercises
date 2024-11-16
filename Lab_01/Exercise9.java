public class Exercise9 {
    public static void sequenceOfHeitone(int n) {
        while (n != 1) {
            if (n % 2 == 1) {
                System.out.printf("%d is odd, so we take 3n+1: %d%n", n, 3 * n + 1);
                n = 3 * n + 1;
            } else {
                System.out.printf("%d is even, so we take n/2: %d%n", n, n / 2);
                n = n / 2;
            }
        }
    }
    public static void main(String[] args) {
        int n = 5;
        sequenceOfHeitone(n);
    }
}
