public class Exercise13 {
    public static boolean isPalindrome(int n) {
        int originalN = n;
        int reverseN = 0;

        while (n != 0) {
            int digit = n % 10;
            reverseN = reverseN * 10 + digit;
            n /= 10;
        }

        return originalN == reverseN;
    }

    public static void main(String[] args) {
        int a = 12321;
        int b = 123456;

        System.out.printf("%d is a palindrome: %b\n",a,isPalindrome(a));
        System.out.printf("%d is a palindrome: %b",b,isPalindrome(b));
    }
}
