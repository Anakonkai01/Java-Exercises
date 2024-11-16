import java.util.Arrays;

public class Exercise10 {
    public static int findThirdLargest(int[] arr) {
        Arrays.sort(arr);
        int countDifferent = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[i + 1]) {
                countDifferent++;
            }
            if (countDifferent == 3) {
                return arr[i];
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int thirdLargest = findThirdLargest(arr);
        System.out.println("Third largest element: " + thirdLargest);
    }
    
    
}
