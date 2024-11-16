
public class Exercise3 {
    public static int sumEven(int arr[]) {
        int sum = 0;
        for(int i : arr){
            if(i%2==0) sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5,6};
        int sum = sumEven(arr);
        System.out.println("Sum all even numbers = "+sum);
    }
}
