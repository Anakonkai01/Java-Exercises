public class Exercise1{
    
    //1a
    public static boolean removeElement(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0; // Set the last element to 0
                return true;
            }
        }
        return false;
    }
    
    // 1b
    public static void insertElement(int[] arr, int k, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = k;
    }
    
    // 1c
    public static int[] findDuplicates(int[] arr) {
        int[] duplicates = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicates[count++] = arr[i];
                    break;
                }
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++){
            result[i] = duplicates[i];
        }
        return result;
    }
    
    // 1d
    public static int[] removeDuplicates(int[] arr) {
        int[] removeDuplicatesArr = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (arr[i] == removeDuplicatesArr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                removeDuplicatesArr[index++] = arr[i];
            }
        }
        int[] result = new int[index];
        for(int i = 0; i < index; i++) {
            result[i] = removeDuplicatesArr[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 1, 3, 2, 4};
        
        // 1a
        System.out.println("Removing element 3: " + removeElement(arr1, 3));
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 1b
        int[] arr2 = {1, 3, 1, 3, 2, 4};
        insertElement(arr2, 5, 2);
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 1c
        int[] arr3 = {1, 3, 1, 3, 2, 4};
        int[] duplicates = findDuplicates(arr3);
        for (int num : duplicates) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 1d
        int[] arr4 = {1, 3, 1, 3, 2, 4};
        int[] uniqueValues = removeDuplicates(arr4);
        for (int num : uniqueValues) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
