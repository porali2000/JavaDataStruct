package arrays;

import java.util.Arrays;

public class ArrayManupulation {




    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long max = -1;
        int from = -1;
        int to = -1;
        int toAdd = 0;
        int arr[] = new int[n];

        int i = 0;
        while (i < queries.length) {
            from = queries[i][0];
            to = queries[i][1];
            toAdd = queries[i][2];
            int j = 0;
            while (j < arr.length) {
                if ((j + 1  >= from) &&  (j + 1) <= to ) {
                    arr[j] = arr[j]  + toAdd;
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                j++;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int queries[][] = { { 1,5,3}, { 4,8,7},{ 6,9,1} };
        int n = 10;
        System.out.println(arrayManipulation(n,queries));
    }

    static void print(int[] arr) {
        int j = 0;
        while (j < arr.length) {
            System.out.print(" " + arr[j]);
            j++;
        }
        System.out.println();
    }


}
