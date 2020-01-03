package retries;



import org.junit.Test;

import java.util.Arrays;

public class MyArray {

    @Test
    public void testArrayBuild(){
        int n = 3;
        Integer[][][] a1 = new Integer[n][n][n];
        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < n; j++ ) {
                for(int k = 0; k < n; k++ ) {
                    a1[i][j][k] = i+j+k;
                }
            }
        }
        Arrays.stream(a1).forEach(x-> {
            Arrays.stream(x).forEach(y-> {
                Arrays.stream(y).forEach(z -> {
                    System.out.print(z);System.out.print("'");
                });
                System.out.print("|");
            });System.out.println();
        });
    }
}
