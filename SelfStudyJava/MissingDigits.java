public class MissingDigits{
    
    public static void getMissingDigits(int input) {
        int[] digits = {0,1,2,3,4,5,6,7,8,9};
        boolean[] missingDigits = new boolean[ digits.length ];
        while (input >= 0) {
            int remain = input % 10;
            input /= 10;
            for (int i = 0; i < digits.length; i++) {
                if(remain == digits[i]){
                    missingDigits[i] = true;
                }
                else{
                    missingDigits[i] = false;
                }
            }
        }
        System.out.println("Missing digits: ");
        for (int i = 0; i < digits.length; i++) {
            if(missingDigits[i] == true){
                System.out.println(digits[i]);
            }
        }
    }
    public static void main(String[] args) {
        
        int input = 73015;
        getMissingDigits(input);
    }
}