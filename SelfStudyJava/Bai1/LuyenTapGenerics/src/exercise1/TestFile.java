package exercise1;

import java.io.*;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/nguye/Downloads/concu.txt",true));
            String data = "hello world";
            bw.append(data);
            bw.newLine();
            bw.append("chao em");
            bw.close();
        } catch (IOException e) {
            System.err.println("Failed");
        }
    }
}
