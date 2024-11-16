package luyencholab9;

import java.io.*;
import java.util.Scanner;

public class exercise5 {
    public static <T> void copyData(String path1,String path2){
        try {
            Scanner br1 = new Scanner(new FileReader(path1));
            PrintWriter wr1 = new PrintWriter(new FileWriter(path2));
            String line;
            while (br1.hasNextLine()) {
                line = br1.nextLine();
                wr1.println(line);
            }
            br1.close();
            wr1.close();
        }
        catch (IOException e) {
            System.err.println("Error opening file " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        copyData("input.txt","output.txt");
        System.out.println("Copy Successful");
    }
}
