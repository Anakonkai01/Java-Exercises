package luyencholab9;

//Xử lý File và HashMap:
//Viết một ứng dụng Java để đọc nội dung của một tệp văn bản và đếm số lần xuất hiện của mỗi từ.
// Sử dụng một HashMap<String, Integer> để lưu trữ các từ và số lần xuất hiện của chúng.
// Xử lý các ngoại lệ có thể phát sinh khi đọc tệp.


import java.io.*;
import java.util.*;

public class exercise1 {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        try {
            Scanner sc = new Scanner(new FileReader("input.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordCount.put(word, wordCount.getOrDefault(word,0)+1);
                }
            }
            sc.close();
            PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
            pw.println(wordCount);
            pw.close();
        } catch (IOException e) {
            System.err.println("Error file" + e.getMessage());
        }
        for(Map.Entry<String,Integer> entry : wordCount.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
