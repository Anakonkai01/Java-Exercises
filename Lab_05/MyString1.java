public class MyString1 {
    // 1a
    public static String shortName(String str){
        String[] parts = str.split(" ");
        return  parts[parts.length - 1]+" "+parts[0];
    }
    
    // 1b
    public static String hashtagName(String str){
        String[] parts = str.split(" ");
        return "#"+parts[parts.length -1]+parts[0];
    }
    // 1c
    public static String upperCaseAllVowel(String str){
        String vowel = "ueoai";
        StringBuilder newStr = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(vowel.contains(String.valueOf(c))){
                newStr.append(Character.toUpperCase(c));
            }
            else {
                newStr.append(c);
            }
        }
        return newStr.toString();
    }
    // 1d
    public static String upperCaseAllN(String str){
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < str.length() ; i++){
            if(str.charAt(i) == 'n'){
                newStr.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
    
    public static void main(String[] args) {
        String str = "Nguyen Tran Hoang Nhan";
        System.out.println("Short name: " + shortName(str));
        System.out.println("Hashtag name: "+hashtagName(str));
        System.out.println("Upper case the vowel: "+upperCaseAllVowel(str));
        System.out.println("Upper case letter n: "+ upperCaseAllN(str));

    }
}
