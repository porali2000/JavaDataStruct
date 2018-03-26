import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestSorting {

    @Test
    public void testSortIntegersNaturally(){
        int[] unSorted = {34,21,4365,587,23};
        int[] sorted = {21,23,34,587,4365};

        Arrays.sort(unSorted);

        Assert.assertArrayEquals(unSorted,sorted);
    }



    @Test
    public void testSortObjectsNaturally(){
        String[] unSorted = {"a","ff","zzz","xssd"};
        String[] sorted = {"a","ff","xssd","zzz"};

        Arrays.sort(unSorted);

        Assert.assertArrayEquals(unSorted,sorted);
    }

    @Test
    public void testReverseOrderingList(){
        List<Integer> input =  Arrays.asList(32,34,646,321,143,64);
        List<Integer> inputReversed =  Arrays.asList(646,321,143,64,34,32);

        Collections.sort(input, new ReverseOrdering());

        Assert.assertEquals(inputReversed,input);
    }

    @Test
    public void testBubbleSort(){

        int[] unSorted = {34,21,4365,587,23};
        int[] sorted = {21,23,34,587,4365};

        boolean isSwitched;

        do{
            isSwitched = false;

            for(int i = 0; i < unSorted.length - 1; i++ ){
                if(unSorted[i] > unSorted[i+1]){
                    int temp = unSorted[i];
                    unSorted[i]= unSorted[i+1];
                    unSorted[i+1] = temp;
                    isSwitched = true;
                }
            }

        }while(isSwitched);

        Assert.assertArrayEquals(sorted,unSorted);

    }

    @Test
    public void testInsertionSort(){
        int[] unSorted = {34,21,4365,587,23};
        int[] sorted = {21,23,34,587,4365};

        for (int i=0; i <= unSorted.length-1; i++){
            for(int j=i; j>0; j--){
                if(unSorted[j] < unSorted[j - 1]) {
                    int temp = unSorted[j];
                    unSorted[j] = unSorted[ j - 1];
                    unSorted[j - 1] = temp;
                }
            }
        }

        for (int value: unSorted){
            System.out.print(" "+value+",");
        }

        Assert.assertArrayEquals(sorted,unSorted);
    }


    /*
      method to test quick sort
    */

    @Test
    public void testQuicksort() {
        List<Integer> actual = Arrays.asList(4,3,2,1);
        List<Integer> expected = Arrays.asList(1,2,3,4);
        List<Integer> sortedList = quickSort(actual);
        Assert.assertEquals(expected, sortedList);

    }

    /**
     *   Method to do quick sort

     **/

    public List<Integer> quickSort(List<Integer> listToSort) {
        if(listToSort.size() < 2 ) {
            return listToSort;
        }

        int pivotValue = listToSort.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();

        for( int i = 1; i <= listToSort.size() - 1; i++) {
            if( listToSort.get(i) < pivotValue) {
                lower.add(listToSort.get(i));
            }
            else {
                higher.add(listToSort.get(i));
            }
        }

        List<Integer> finalSortedList = quickSort(lower);
        finalSortedList.add(pivotValue);
        finalSortedList.addAll(quickSort(higher));
        return finalSortedList;

    }



    @Test
    public void testMergeSort(){
        List<Integer> actual = Arrays.asList(33,5,12,6,7,8,14);
        List<Integer> expected = Arrays.asList(5,6,7,8,12,14,33);

//        List<Integer> actual = Arrays.asList(33,22,2);
//        List<Integer> expected = Arrays.asList(2,22,33);

        List<Integer> mergedList = mergeSort(actual);

        for (int value: mergedList){
            System.out.print(" "+value+",");
        }

        Assert.assertEquals(expected,mergedList);

    }

    public List<Integer> mergeSort(List<Integer> lists){
        if(lists.size() < 2) {
            return lists;
        }

        int middle = lists.size() / 2;
        List<Integer>  left = lists.subList(0,middle);
        List<Integer>  right = lists.subList(middle, lists.size());
        return merge(mergeSort(left), mergeSort(right));
    }

    public List<Integer> merge( List<Integer> left, List<Integer> right){
        int leftPointer = 0;
        int rightPointer = 0;

        List<Integer> merged = new ArrayList<>(left.size() + right.size());

        while (leftPointer < left.size() && rightPointer < right.size()) {
            if (left.get(leftPointer) < right.get(rightPointer)) {
                merged.add(left.get(leftPointer));
                leftPointer++;
            } else {
                merged.add(right.get(rightPointer));
                rightPointer++;
            }
        }

        while(leftPointer < left.size()){
            merged.add(left.get(leftPointer));
            leftPointer++;
        }
        while (rightPointer < right.size()) {
            merged.add(right.get(rightPointer));
            rightPointer++;
        }

        return merged;

    }

       /*
      method to test quick sort
    */

    @Test
    public void testBinarySearch() {
        List<Integer> actual = Arrays.asList(1,2,3,4);
        boolean isFound = binarySearch(actual, 4);
        Assert.assertEquals(true, isFound);

    }

    /**
     *   Method to do binary sort

     **/
    public boolean binarySearch(List<Integer> listAvailable, Integer valueToFind) {
        if(listAvailable == null || listAvailable.size() == 0 ) {
            return false;
        }

        int comparison = listAvailable.get(listAvailable.size()/2);

        if(valueToFind.equals(comparison)) {
            return true;
        } else if( valueToFind < comparison ) {
            return binarySearch(listAvailable.subList(0, listAvailable.size() / 2), valueToFind);
        } else {
            return binarySearch(listAvailable.subList( listAvailable.size()/2 + 1, listAvailable.size()), valueToFind);
        }

    }

}