package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("A");
        myList.add("B");
        myList.add("c");
        myList.add(3, "d");
        myList.add(1, "e");

        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }

        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is c is in list: " + myList.contains("c"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("B");

        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
