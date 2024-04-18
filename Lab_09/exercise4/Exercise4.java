package exercise4;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise4 {
    public static List<File> filesExtension(String path, String extensionName) {
        File folder = new File(path);
        if (!folder.exists()) {
            return null;
        }
        File[] files = folder.listFiles();
        List<File> filesContainsExtension = new ArrayList<>();

        if (files != null) {
            for (File f : files) {
                if (f.getName().contains(extensionName)) {
                    filesContainsExtension.add(f);
                }
            }
        }

        return filesContainsExtension;
    }

    public static boolean checkExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static String checkFileOrDirectory(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            return (file.getName() + " is a directory");
        } else if (file.isFile()) {
            return (file.getName() + " is a file");
        } else {
            return (file.getName() + " does not exist.");
        }
    }


    public static void appendText(File file, String text) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.append(text);
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot append" + e.getMessage());
        }
    }

    public static String longestWord(File file) {
        Map<String,Integer> mapWordCount = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new FileReader(file));
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                Matcher matcher = Pattern.compile("\\b[a-zA-Z]+\\b").matcher(line);
                while (matcher.find()) {
                    String word = matcher.group();
                    mapWordCount.put(word, word.length());
                }
            }
            System.out.println(mapWordCount);
            String longestWord = "";
            int maxLength = 0;
            for(Map.Entry<String, Integer> entry : mapWordCount.entrySet()){
                if(entry.getValue() > maxLength) {
                    longestWord = entry.getKey();
                    maxLength = entry.getValue();
                }
            }
            return longestWord; // if there are more word which have the same length so we need return the list of word right ???
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\nguye\\OneDrive\\Desktop\\test.txt";
        File file = new File(path);
        System.out.println(longestWord(file));
    }
}
