import java.util.ArrayList;
import java.util.List;

public class Exercise9{
    public static int[] divisibleNumbers(int arr[], int k) {
        List<Integer> divisibleList = new ArrayList<>();
        for (int num : arr) {
            if (num % k == 0) {
                divisibleList.add(num);
            }
        }
        int[] divisibleArray = new int[divisibleList.size()];
        for (int i = 0; i < divisibleList.size(); i++) {
            divisibleArray[i] = divisibleList.get(i);
        }
        return divisibleArray;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 25, 100};
        int k = 5;
        int[] divisible = divisibleNumbers(arr, k);
        System.out.println("Elements divisible by " + k + ":");
        for (int num : divisible) {
            System.out.print(num + " ");
        }
    }
    
    
}
