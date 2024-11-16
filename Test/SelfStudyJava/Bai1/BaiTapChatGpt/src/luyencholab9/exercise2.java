package luyencholab9;
//Xử lý Ngoại lệ và Generics:
//Viết một phương thức generics trong Java để tìm và trả về phần tử lớn nhất từ một mảng.
//Xử lý trường hợp ngoại lệ khi mảng trống hoặc null.

import java.util.Random;

public class exercise2 {
    public static <T extends Comparable <T>> T largestNumber(T[] list){
        if(list.length == 0 || list == null){
            throw new IllegalArgumentException("Error");
        }

        T max = list[0];
        for(T element : list){
            if(element.compareTo(max) > 0){
                max = element;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] list = new Integer[10];
        for(int i = 0; i < 10; i++){
            list[i] = rand.nextInt(100);
        }
        System.out.println(largestNumber(list));
    }
}
