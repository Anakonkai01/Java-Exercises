
public class Exercise4 {
    public static int countSpecific(int arr[],int k) {
        int count =0;
        for(int i : arr){
            if(k == i){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,2,2};
        int k = 2;
        System.out.println("Number "+ k +" appear: " +countSpecific(arr,k) +" times");
    }
}
