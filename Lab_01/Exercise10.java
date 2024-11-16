public class Exercise10 {
    public static int sumOfFirstAndLastDigit(int n) {
        //convert to string
        String numberStr = String.valueOf(n);
        char firstChar = numberStr.charAt(0);
        char lastChar = numberStr.charAt(numberStr.length() - 1);

        return Character.getNumericValue(firstChar) + Character.getNumericValue(lastChar);
    }
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("The sum of first and last of "+n+" digits is: "+sumOfFirstAndLastDigit(n));
    }
}
