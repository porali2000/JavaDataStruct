package arrays;

abstract class Arr {
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
}
