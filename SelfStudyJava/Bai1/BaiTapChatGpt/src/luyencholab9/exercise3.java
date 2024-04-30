package luyencholab9;
//Tạo một lớp generics trong Java để thực hiện các thao tác cơ bản với tệp,
// như đọc nội dung từ một tệp và trả về một danh sách các đối tượng từ dữ liệu trong tệp.
// Xử lý các ngoại lệ có thể xảy ra trong quá trình đọc tệp.

import java.util.ArrayList;
import java.util.List;
import java.io.*;
class FileProcess <T> {
    public List<T> readFile(String fileName) {
        List<T> list = new ArrayList<T>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null){
                T data = (T) line;
                list.add(data);
            }
        }
        catch (IOException e){
            System.err.println("Error reading file " + e.getMessage());
        }
        return list;
    }
}


public class exercise3 {
    public static void main(String[] args) {
        FileProcess fp = new FileProcess();
        for(Object t: fp.readFile("input.txt")){
            System.out.println(t);
        }
    }
}
