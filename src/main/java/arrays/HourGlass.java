package arrays;


public class HourGlass {
    static int x = 6;
    static int y = 6;

    public static void main(String[] args) {
        int[][] array = new int[x][y];
        print(array);
    }

    static void print(int[][] array) {
        int xlocal = x;
        int i = 0;
        while (xlocal > 0) {
            int ylocal = y;
            --xlocal;
            int j = 0;
            while (ylocal > 0) {
                --ylocal;
//                System.out.print(" " + array[i][j]);
                try {
                    System.out.println("Sum: " + (array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j + 1]
                            + array[i + 2][j]  + array[i + 2][j + 1]  + array[i+ 2][j + 2]));
                    System.out.println(array[i][j] + " " + array[i][j + 1] + " " + array[i][j + 2]);
                    System.out.println(" " + " " + array[i + 1][j + 1] + " " + " ");
                    System.out.println(array[i + 2][j] + " " + array[i + 2][j + 1] + " " + array[i+ 2][j + 2]);
                    System.out.println();
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                j++;
            }
            System.out.println();
        }
    }
}
