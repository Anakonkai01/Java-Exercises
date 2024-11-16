package luyencholab9;

import java.util.HashMap;
import java.util.Map;

public class exercise4 {
    public static <K, V> void addToHashMap(Map<K, V> map, K key, V value) {
        if (map == null || key == null || value == null) {
            throw new IllegalArgumentException("Map, key, and value must not be null");
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        addToHashMap(myMap, "one", 1);
        addToHashMap(myMap, "two", 2);
        addToHashMap(myMap, "three", 3);
        addToHashMap(myMap,null,null);
        System.out.println(myMap);
    }
}
