package arrays;


public class HourGlass {
    static int x = 6;
    static int y = 6;

    public static void main(String[] args) {
//        int[][] array = new int[x][y];
        int[][]  array = {
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}
        };
        System.out.println(larget(array));
    }

    static int larget(int[][] array) {
        Integer largest = null;
        int xlocal = x;
        int i = 0;
        while (xlocal > 0) {
            int ylocal = y;
            --xlocal;
            int j = 0;
            while (ylocal > 0) {
                --ylocal;
                try {
                    System.out.println(array[i][j] + " " + array[i][j + 1] + " " + array[i][j + 2]);
                    System.out.println(" " + " " + array[i + 1][j + 1] + " " + " ");
                    System.out.println(array[i + 2][j] + " " + array[i + 2][j + 1] + " " + array[i + 2][j + 2]);
                    int sum = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j + 1]
                            + array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];
                    System.out.println("Sum: " + sum);
                    if (null == largest || sum > largest) {
                        largest = sum;
                    }
                    System.out.println();
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                j++;
            }
            i++;
            System.out.println();
        }
        return largest;
    }
}
