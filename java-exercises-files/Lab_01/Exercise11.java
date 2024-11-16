public class Exercise11 {
    public static int countDigit(int n){
        String numberStr = String.valueOf(n);
        return numberStr.length();
    }
    public static void main(String[] args) {
        int n = 12345;
        System.out.printf("The length of %d is: %d", n, countDigit(n));
    }
}
