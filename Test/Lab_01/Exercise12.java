public class Exercise12 {
    public static int reverseNumber(int n){
        int reverseN =0;
        while(n != 0){
            int digit = n%10;
            reverseN = reverseN*10 + digit;
            n /= 10;
        }
        return reverseN;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.printf("The reverse of %d is: %d",n,reverseNumber(n));
    }
}
