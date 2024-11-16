import java.math.BigDecimal;

public class Exercise8{
    
    
    public static BigDecimal findMax(BigDecimal[] arr) {
        BigDecimal max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BigDecimal[] arr = {new BigDecimal("12.3"), new BigDecimal("3.5"), new BigDecimal("5.6")};
        System.out.println("Maximum value: " + findMax(arr));
    }
}
