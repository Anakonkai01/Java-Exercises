public class Exercise5{
    public static String[][] countWordFrequency(String paragraph) {
        String[] words = paragraph.toLowerCase().split("\\W+"); 
        String[][] wordFrequency = new String[words.length][2];

        int count;
        int index = 0;

        // Count
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Check counted
            boolean counted = false;
            for (int j = 0; j < index; j++) {
                if (wordFrequency[j][0].equals(word)) {
                    count = Integer.parseInt(wordFrequency[j][1]);
                    wordFrequency[j][1] = String.valueOf(count + 1);
                    counted = true;
                    break;
                }
            }

            // if not counted,add the word
            if (!counted) {
                wordFrequency[index][0] = word;
                wordFrequency[index][1] = "1";
                index++;
            }
        }

        //remove null values
        return java.util.Arrays.copyOf(wordFrequency, index);
    }

    public static void main(String[] args) {
        String paragraph = "You are living on a Plane. What you style Flatland is the vast level surface of what I may call a fluid, on, or in, the top of which you and your countrymen move about, without rising above it or falling below it.";
        String[][] wordFrequency = countWordFrequency(paragraph);
        System.out.println("Word Frequency:");
        for (String[] i : wordFrequency) {
            System.out.println(i[0] + ": " + i[1]);
        }
    }
}
