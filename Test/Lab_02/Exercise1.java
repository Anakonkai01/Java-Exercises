
public class Exercise1 {
    public static int findMax(int arr[]) {
        int max = arr[0];
        for(int i : arr) {
            if(max < i) {
                max = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5};
        int max = findMax(arr);
        System.out.println("Max = "+max);
    }
}
