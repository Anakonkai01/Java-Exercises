package exercise2;

import java.io.*;
import java.util.*;

public class Exercise2 {
    public static void UpperCaseLetter(String inputPath, String outputPath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
        String line;
        List<String> data = new ArrayList<String>();
        while((line = br.readLine()) != null ) {
            data.add(line.toUpperCase());
            data.add("\n");
        }
        if(!data.isEmpty()) {
            data.remove(data.size()-1);
        }
        for(String s : data) {
            bw.write(s);
        }
        br.close();
        bw.close();
    }

    public static void main(String[] args)  {
        // create inputFile 
        try {
            FileWriter fileTest = new FileWriter("input.txt");
            fileTest.write("information technology\nobject oriented programming");
            fileTest.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // uppercase
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try {
            UpperCaseLetter(inputPath, outputPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


