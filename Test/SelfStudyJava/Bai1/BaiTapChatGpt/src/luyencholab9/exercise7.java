package luyencholab9;


// Viết một lớp generics trong Java để đại diện cho một danh sách các phần tử.
// Lớp này nên có các phương thức để thêm phần tử, loại bỏ phần tử, và lấy một phần tử tại một vị trí cụ thể.
// Xử lý các ngoại lệ có thể phát sinh khi thêm hoặc lấy phần tử từ danh sách
// (ví dụ: truy cập phần tử ngoài phạm vi của danh sách).


import java.util.ArrayList;
import java.util.List;

class ListOfElement<T>{
    private List<T> list;
    public ListOfElement(){
        this.list = new ArrayList<>();
    }
    public void add(T element){
        list.add(element);
    }

    public T get(int index){
        if(index < 0 || index >= list.size()) throw new IndexOutOfBoundsException("Index out of bounds");
        return list.get(index);
    }

    public void remove(int index){
        if(index < 0 || index >= list.size()) throw new IndexOutOfBoundsException("Index out of bounds");
        list.remove(index);
    }

    public void displayInfo(){
        for(T element : list){
            System.out.println(element);
        }
    }
}

public class exercise7 {
    public static void main(String[] args) {
        ListOfElement list = new ListOfElement();
        list.add(100);
        list.add(200);
        list.add(300);
        list.displayInfo();
        try{
            list.get(4);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bounds");
        }
    }
}
