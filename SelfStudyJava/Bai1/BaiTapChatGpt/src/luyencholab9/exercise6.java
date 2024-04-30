package luyencholab9;

import java.awt.image.ImageProducer;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.Map;

public class exercise6 {
    public static <T,U> T checkKey(HashMap<T,U> map,T key){
        if(map.isEmpty() || key == null) throw new IllegalArgumentException("map is empty");
        if(!map.containsKey(key)) throw new IllegalArgumentException("key is not found");
        return key;
    }
    public static <T> void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("hello",1);
        map.put("world",2);
        T t = (T) checkKey(map,"Bello");
        System.out.println(t);
    }
}
