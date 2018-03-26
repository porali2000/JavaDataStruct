package retries;

import org.junit.Test;
import java.util.Arrays;
import java.util.Hashtable;

public class Search {

    static Integer[] integers = null;

    public static int indexOf(int value, Object[] sourceList) {
        for (int i = 0; i < sourceList.length; i++) {
            if ((Integer)sourceList[i] == value) {
                return i;
            }
        }
        return  -1;
    }

    public static int indexOfM1(int value, Object[] sourceList) {
        if(sourceList.length > 0) {
            int first = (int) sourceList[0];
            int last = (int) sourceList[sourceList.length - 1];

        }

        return -1;
    }

    @Test
    public void testHashTable(){
        int[] values = {12,23,435,999};
        Search.hashTable(values);
        System.out.println(Search.findInHash(23));
    }

    public static String hashTable(int[] values){
        integers = new Integer[values.length];

        for(int x: values) {
            int proj = hashfunction(x,values.length);
            while (proj < values.length) {
                if(integers[proj] == null) {
                    integers[proj] = x;
                    break;
                }
                proj++;
            }
        }

        System.out.println(Arrays.asList(integers));

        return "";
    }

    private static int hashfunction(int value, int size) {

        return value %  size;

    }

    public static int findInHash(int value) {
        if(integers[hashfunction(value,integers.length)] == value ) {
            return hashfunction(value,integers.length);
        }
        return  -1;
    }


    public static boolean linearSearch(int[] list, int valueToSearch) {
        if (list == null || list.length < 0) {
            return false;
        }
        for(int i = 0; i< list.length; i++ ){
            if (list[i] == valueToSearch) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] list, int valueTOFind) {
        if (null == list || list.length < 0) {
            return false;
        }

        int low = 0;
        int high = list.length -1;

        return  binarySearch(low, high, list, valueTOFind );

    }

    public static boolean binarySearch(int low, int high, int[] list, int valueTOFind){
        int mid = low + (high - low) / 2 ;
        if (low == high + 1) {
            return false;
        }
        if(list[mid] == valueTOFind) {
            return true;
        } else if( list[mid] > valueTOFind ) {

            return binarySearch(low, mid - 1, list, valueTOFind );
        } else {
            return binarySearch(mid + 1, high, list, valueTOFind );
        }


    }
}