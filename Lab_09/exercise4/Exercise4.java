package exercise4;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise4 {
    // task 1
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

    // task 2
    public static boolean checkExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    // task 3
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

    // task 4
    public static void appendText(String path, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.append(text);
        writer.close();
    }

    // task 5
    public static String longestWord(String path) throws IOException {
        Map<String,Integer> mapWordCount = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while((line = reader.readLine()) != null){
            Matcher matcher = Pattern.compile("\\b[a-zA-Z]+\\b").matcher(line);
            while (matcher.find()) {
                String word = matcher.group();
                mapWordCount.put(word, word.length());
            }
        }
        reader.close();
        String longestWord = "";
        int maxLength = 0;
        for(Map.Entry<String, Integer> entry : mapWordCount.entrySet()){
            if(entry.getValue() > maxLength) {
                longestWord = entry.getKey();
                maxLength = entry.getValue();
            }
        }

        return longestWord; // if there are more word which have the same length so we need return the list of word right ???
    }

    public static void main(String[] args) {
        String inputPath;
        
        // task 1
        System.out.println("Task 1:");
        inputPath = "test/task1";
        String extension = "txt";
        for (File file : filesExtension(inputPath, extension)) {
            System.out.println("File " + file);
        }

        // task 2
        System.out.println();
        System.out.println("Task 2:");
        inputPath = "test/task2/test1.cpp";
        System.out.println(inputPath+" is exists: "+checkExist(inputPath));

        // task 3
        System.out.println();
        System.out.println("Task 3:");
        inputPath = "test/task3/test1.cpp";
        System.out.println(inputPath+":  "+checkFileOrDirectory(inputPath));
        inputPath = "test/task3/test2.txt";
        System.out.println(inputPath+":  "+checkFileOrDirectory(inputPath));
        inputPath = "test/task3";
        System.out.println(inputPath+":  "+checkFileOrDirectory(inputPath));

        // task 4
        System.out.println();
        System.out.println("Task 4:");
        inputPath = "test/task4/test.txt";
        String appendString = ", nice too meet you";
        try{
            appendText(inputPath, appendString);
            System.out.println("Append successfully");
        }
        catch (IOException e){
            System.err.println("Error: "+e.getMessage());
        }

        // task 5
        System.out.println();
        System.out.println("Task 5:");
        inputPath = "test/task5/test.txt";
        try{
            System.out.println("Longest Word in file '"+inputPath+"' is: "+longestWord(inputPath));
        }
        catch (IOException e){
            System.err.println("Error: "+e.getMessage());
        }
    }
}
