package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.add("F");

        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of HashSet: " + hs.size());

        System.out.println("Removing C from HashSet: " + hs.remove("C"));
        if(hs.remove("E")) {
            System.out.println("E removed from the Set");
        } else {
            System.out.println("E is not present in the Set");
        }

        System.out.println("Checking if B is present: " + hs.contains("B"));
        System.out.println("Updated HashSet: " + hs);
    }
}
