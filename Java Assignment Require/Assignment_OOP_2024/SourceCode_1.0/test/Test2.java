package test;

import java.lang.reflect.Array;
import java.util.ArrayList;

class Test2 {

    public static void main(String[] args) {
        ArrayList array1 = new ArrayList<>();

        array1.add(1);
        array1.add(1);
        array1.add(1);

        ArrayList array2 = new ArrayList<>();
        array2.add(1);
        array2.add(1);

        // ArrayList array3 = new ArrayList<>();
        // array3.add(3);
        
        array2.retainAll(array1);
        // array1.retainAll(array3);

        
        System.out.println(array2);
    }
}