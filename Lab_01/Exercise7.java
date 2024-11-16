public class Exercise7 {
    public static boolean isAlphanumeric(char character) {
        return (character >= '0' && character <= '9') || (character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z');
    }

    public static void main(String[] args) {
        // Example usage:
        char c = '7';

        if (isAlphanumeric(c)) {
            System.out.println(c + " is an alphanumeric character.");
        } else {
            System.out.println(c + " is not an alphanumeric character.");
        }
    }
}
