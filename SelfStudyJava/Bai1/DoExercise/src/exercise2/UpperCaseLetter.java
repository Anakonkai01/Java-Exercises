package exercise2;

import java.io.*;
import java.util.*;

public class UpperCaseLetter {

    public static void main(String[] args)  {
        try {
            FileWriter fileTest = new FileWriter("input.txt");
            fileTest.write("information technology\nobject oriented programming");
            fileTest.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
