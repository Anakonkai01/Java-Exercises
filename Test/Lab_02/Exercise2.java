
public class Exercise2 {
    public static int findMin(int arr[]) {
        int min = arr[0];
        for(int i : arr) {
            if(min > i) {
                min = i;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5};
        int min = findMin(arr);
        System.out.println("Min = "+min);
    }
}
