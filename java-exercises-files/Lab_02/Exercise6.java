
public class Exercise6 {
    public static int find(int arr[], int k){
        for (int i = 0; i < arr.length ; i++){
            if( arr[i] == k) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5,6,7};
        int k = 4;
        if (find(arr,k) == -1){
            System.out.println("the element doesn’t exist");
        }
        else {
            System.out.println("the index of an element k in an array is: "+ find(arr,k));
        }
    }
}
