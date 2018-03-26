package retries;

import org.junit.Test;

import java.util.ArrayList;

public class ArraysTest {

    @Test
    public void testMissingNumber(){

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("7");
        //code

        int ref = 1;
        for(String x: arrayList) {
            if(Integer.valueOf(x).intValue() != ref) {
                System.out.println(ref);
                break;
            }
            ref++;
        }
    }

    @Test
    public void testLeader() {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("7");



    }
}
