package retries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TestSort {

    List<Integer> expected = null;

    @Before
    public void setup() {
        expected = Arrays.asList(9,8,7,6,5,4,3,2,1,0);
    }
    @Test
    public void testBinarySort() {
        List<Integer> source = new ArrayList<>();
        source.add(43);
        source.add(3);
        source.add(4);
        source.add(493);
        List<Integer> actual = Sort.binarySort(source);
        List<Integer> expected = Arrays.asList(3, 4, 43, 493);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCollection() {
        List<Integer> expected = Arrays.asList(3, 4, 43, 493);
        List<Integer> source = new ArrayList<>();
        source.add(43);
        source.add(3);
        source.add(4);
        source.add(493);
        List<Integer> source2 = new ArrayList<>();
        source2.add(43);
        source2.add(4);

        Collections.sort(source);
//        System.out.println(Collections.indexOfSubList(source,source2));
//        System.out.println(Collections.lastIndexOfSubList(source,source2));
//        System.out.println(Collections.max(source));
//        System.out.println(Collections.max(source,new Reverse()));
//        Collections.rotate(source,0);
//
//        System.out.println(source);
//        System.out.println(source2);

        Iterator it = source.iterator();
        while (it.hasNext()){
            System.out.println(it.next());

        }

        ListIterator listIterator = source.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next());
            System.out.print(" ");
            System.out.print(listIterator.previous());
            System.out.print(" ");
            System.out.print(listIterator.previousIndex());
            System.out.print(" ");
            System.out.print(listIterator.next());
            System.out.print(" ");
        }
    }

    @Test
    public void testBubbleSort(){
        System.out.println(expected);
        List<Integer> integers = Sort.bubbleSort(expected);
        System.out.println(integers);
    }

    @Test
    public void testMerge(){
        Integer[] a1 = {4,3};
        Integer[] a2 = {2,1,0};
        System.out.println(Arrays.asList(Sort.merge(a1,a2)));
    }

    @Test
    public void testInsertionSort(){
        Integer[] a2 = {2,1,0};
        System.out.println(Arrays.asList(Sort.insertionSort(a2)));
    }

    @Test
    public void testSelectionSort(){
        Integer[] a2 = {7,6,5,4,3,2,1,0};
        System.out.println(Arrays.asList(Sort.selectionSort(a2)));
    }

    @Test
    public void testMergeSort(){
        Integer[] a2 = {8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.asList(Sort.mergeSort(a2)));
    }
}
