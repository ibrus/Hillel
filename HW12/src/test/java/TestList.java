import Interfaces.StringCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

public class TestList {

    private StringCollection arr;

    @BeforeEach
    public void init() {
        arr = new StringCollectionImpl();
        arr.add("some string");
        arr.add("one more string");
        arr.add("and one more string");
        arr.add("string");
    }

    @Test
    void testSize(){
        Assertions.assertEquals(4, arr.size());
    }

    @Test
    void testGet(){
        Assertions.assertEquals("string", arr.get(3));
    }

    @Test
    void testDelete(){
        arr.delete("string");
        Assertions.assertFalse(arr.contains("string"));
    }

//    @Test
//    void testAdd(){
//        arr.add("string2");
//        Assertions.assertTrue(arr.contains("string2"));
//        Assertions.assertTrue(arr.size()==5);
//    }

    @Test
    void testAdd(){
        arr = mock(StringCollectionImpl.class);
    /*
        You can also use method doAnswer or doThrow for example
        if you want to assert that an Exception will be thrown
    */
        doNothing().when(arr).add(isA(String.class));
        arr.add("string14");
    /*
        Calling the void method, the only case you can test is
        that it was definitely invoked. Thats exactly what verify()
        method does
    */
        verify(arr, times(1)).add("string14");
    }

    @Test
    void testClear(){
        arr.clear();
        Assertions.assertEquals(0, arr.size());
    }

    @Test
    void testEquals(){
        StringCollection arr2 = new StringCollectionImpl();
        arr2.add("some string");
        arr2.add("one more string");
        arr2.add("and one more string");
        arr2.add("string");
        Assertions.assertTrue(arr.equals(arr2));
    }

    @Test
    void testContains(){
        Assertions.assertTrue(arr.contains("some string"));
    }

}
