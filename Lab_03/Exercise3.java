public class Exercise3 {
    //3a
    public static String getLastNameFirstName(String fullName) {
        String[] nameParts = fullName.split(" ");
        String lastName = nameParts[nameParts.length - 1];
        String firstName = nameParts[0];
        return firstName + " " + lastName;
    }
    //3b
    public static String getMiddleName(String fullName){
        String[] nameParts = fullName.split(" ");
        String middleName = "";
        for (int i = 1; i < nameParts.length - 1; i++) {
            middleName += nameParts[i];
            if (i < nameParts.length - 2) {
                middleName += " ";
            }
        }
        return middleName;
    }
    //3c
    public static String capitalizeFullName(String fullName){
        String[] nameParts = fullName.split(" ");
        
        for (int i = 0; i < nameParts.length; i++) {
            nameParts[i] = nameParts[i].substring(0, 1).toUpperCase() + nameParts[i].substring(1).toLowerCase();
        }
        String capitalize = String.join(" ", nameParts);
        return capitalize;
    }
    //3d
    public static String upperCaseVowel(String fullName){
        char[] result = new char[fullName.length()];
        String vowel = "aeiou";
        for (int i = 0; i < fullName.length(); i++) {
            char c = fullName.charAt(i);
            if (Character.isLetter(c)) {
                if (vowel.contains(String.valueOf(c))) {
                    result[i] = Character.toUpperCase(c);
                } else {
                    result[i] = Character.toLowerCase(c);
                }
            } else {
                result[i] = c;
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String fullName = "Nguyen Tran Hoang Nhan";

        // 3a
        System.out.println("Full name: "+fullName);
        String lastAndFirstname = getLastNameFirstName(fullName);
        System.out.println("Last and First name: "+lastAndFirstname); 

        // 3b
        String middleName = getMiddleName(fullName);
        System.out.println("Middle name: "+middleName);

        //3c
        fullName.toLowerCase(); 
        String capString = capitalizeFullName(fullName);
        System.out.println("Capitalize full name: "+capString);

        //3d
        String upperVowel = upperCaseVowel(fullName);
        System.out.println("Uppercase the vowel: "+upperVowel);
    }
}
