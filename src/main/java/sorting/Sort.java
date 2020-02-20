package sorting;

import static org.junit.Assert.assertArrayEquals;

abstract class Sort {

        public static int[] given = {5, 4, 3, 2,1, 0, -1, -2, -3};
        public  static int[] expected = {-3,-2,-1,0,1,2,3,4,5};

    public static void print(int[] toPrint){
        int i = toPrint.length;
        int p = 0;
        while(p < i) {
            System.out.print(toPrint[p] + " ");
            p++;
        }
        System.out.println();
    }

    public static int[] sort(int[] toSort) {
        int l = toSort.length - 1;
        int i = 0;
        int j = 0;
        return toSort;
    }

    public static void assertResult(int[] result){
        assertArrayEquals(expected, result);
    }
}
