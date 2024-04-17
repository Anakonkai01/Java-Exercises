package exercise5;

import java.io.*;
import java.util.*;

public class Exercise5 {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("input.txt"));
            pw.print("0 12 8 4\n6 100 1 9");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.txt"));
            int sum = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String [] arr = (line.split("\\s+"));
                for(String s: arr){
                    sum += Integer.parseInt(s);
                }
            }
            sc.close();
            PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
            pw.print(sum);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
