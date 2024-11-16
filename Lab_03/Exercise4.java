public class Exercise4 {
    
    //4a
    public static int findLength(String str){
        return str.length();
    }
    //4b
    public static int countWords(String str){
        return str.split(" ").length;
    }
    //4c
    public static String concatString(String str1, String str2){
        return str1 +" "+str2;
    }

    //4d
    public static boolean checkPalindrome(String str){
        int ptr1 = 0;
        int ptr2 = str.length() - 1;

        while (ptr1 < ptr2) {
            if (str.charAt(ptr1) != str.charAt(ptr2)) {
                return false;
            }
            ptr1++;
            ptr2--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "Nguyen Tran Hoang Nhan";
        String str2 = "Dep Trai";
        String str3 = "abccba";

        //4a
        System.out.println("Length of " + str1 + " is: " + findLength(str1));
        //4b
        System.out.println("Numbers of words in " + str1+" : " +countWords(str1));
        //4c
        System.out.println("Concatenate str1 with str2: "+concatString(str1, str2));
        //4d
        if (checkPalindrome(str3)) {
            System.out.println(str3 + " is a palindrome.");
        } else {
            System.out.println(str3 + " is not a palindrome.");
        }

    }
}
