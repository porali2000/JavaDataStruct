package retries;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Sort {


    public static List<Integer> binarySort(List<Integer> source) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (null == source || source.size() < 2) {
            return source;
        }


        result.addAll(binarySort(l1));
        result.addAll(binarySort(r1));

        return result;
    }

    public static List<Integer> bubbleSort(List<Integer> sourceList) {
        Integer[] payload = (Integer[]) sourceList.toArray();
        for (int i = 0; i < payload.length; i++) {
            int j = i + 1;
            while (j < payload.length) {
                if (payload[i] > payload[j]) {
                    int temp = payload[i];
                    payload[i] = payload[j];
                    payload[j] = temp;
                }
                j++;
            }
        }
        return Arrays.asList(payload);
    }


    public static Integer[] merge(Integer[] left, Integer[] right) {
        Integer[] merged = new Integer[left.length + right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int mergePointer = 0;

//        System.out.print(Arrays.asList(left));
//        System.out.print("             |              ");
//        System.out.print(Arrays.asList(right));
//        System.out.println();

        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] > right[rightPointer]) {
                merged[mergePointer] = right[rightPointer];
                rightPointer++;
            } else {
                merged[mergePointer] = left[leftPointer];
                leftPointer++;
            }
            mergePointer++;
        }

        while (leftPointer < left.length) {
            merged[mergePointer] = left[leftPointer];
            leftPointer++;
            mergePointer++;
        }

        while (rightPointer < right.length) {
            merged[mergePointer] = right[rightPointer];
            rightPointer++;
            mergePointer++;
        }
        return merged;
    }

    public static Integer[] insertionSort(Integer[] source) {

        int i = 0;
        while (i < source.length - 1) {
            if (source[i] > source[i + 1]) {
                int temp = source[i];
                source[i] = source[i + 1];
                source[i + 1] = temp;

                int j = i;
                while (j > 0) {
                    if (source[j] < source[j - 1]) {
                        int temp2 = source[j];
                        source[j] = source[j - 1];
                        source[j - 1] = temp2;
                    }
                    j--;
                }
            }
            i++;
        }
        return source;
    }


    public static Integer[] selectionSort(Integer[] source) {
        int i = 0;
        while (i < source.length) {
            int j = i + 1;
            while (j < source.length) {
                if (source[i] > source[j]) {
                    int temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                }
                j++;
                System.out.println();
                System.out.println(Arrays.asList(source));
            }
            i++;
        }
        return source;
    }


    public static Integer[] mergeSort(Integer[] source) {

        if (source.length < 2) {
            return source;
        }
        int mid = source.length / 2;
        Integer[] d1 = new Integer[mid];
        int i = 0;
        while (i < mid) {
            if (source[i] != null)
            d1[i] = source[i];
            i++;
        }

        int j = mid;
        int index = 0;
        Integer[] d2 = new Integer[source.length - mid];

        while (j < source.length) {
            if (source[j] != null)
            d2[index] = source[j];
            j++;
            index++;
        }

//        System.out.print(Arrays.asList(d1));
//        System.out.print("        ||       ");
//        System.out.print(Arrays.asList(d2));
//        System.out.println();

        return merge(mergeSort(d1), mergeSort(d2));
    }


}
