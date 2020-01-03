package retries;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSearch {
    int max = 1000000;
    int valueTOFind = 5;
    List<Integer> sourceList = new ArrayList<>();

    @Before
    public void setup(){
        for (int i = 0; i <= max; i++) {
            sourceList.add(i);
        }
    }

    @Test
    public void testSearch() {
        System.out.println(Search.indexOf(max, sourceList.toArray()));
    }

    @Test
    public void testLinearSearch() {
        int[] list = {2,10,15,20,25,30,35,40};
        System.out.println(Search.linearSearch(list, 40));
    }

    @Test
    public void testBinarSearch() {
        int[] list = {2,10,15,20,25,30,35,40};
        System.out.println(Search.binarySearch(list, 40));
    }
}