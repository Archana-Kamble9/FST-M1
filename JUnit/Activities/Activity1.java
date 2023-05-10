package Activities;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    static ArrayList<String> list;

    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("A");
        list.add("B");
    }

    @Test
    public void insertTest() {
        assertEquals(2, list.size(), "Wrong size");
        list.add(2, "C");
        assertEquals(3, list.size(), "Wrong size");

        assertEquals("A", list.get(0), "Wrong element");
        assertEquals("B", list.get(1), "Wrong element");
        assertEquals("C", list.get(2), "Wrong element");
    }

    @Test
    public void replaceTest() {
        list.set(1, "C");

        assertEquals(2, list.size(), "Wrong size");
        assertEquals("A", list.get(0), "Wrong element");
        assertEquals("C", list.get(1), "Wrong element");
    }
}
