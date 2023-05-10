package Activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        hash_map.put(1, "A");
        hash_map.put(2, "B");
        hash_map.put(3, "C");
        hash_map.put(4, "D");
        hash_map.put(5, "E");

        System.out.println("The Original map: " + hash_map);

        hash_map.remove(4);
        System.out.println("After removing D: " + hash_map);

        if(hash_map.containsValue("A")) {
            System.out.println("A exists in the Map");
        } else {
            System.out.println("A does not exist in the Map");
        }

        System.out.println("Number of pairs in the Map is: " + hash_map.size());
    }
}
