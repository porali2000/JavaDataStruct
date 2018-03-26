package algorithms;

import java.math.BigInteger;

public class Factorial {
    public static long factorialLinear(int n) {
        if(n < 1) {
            //throw new IllegalAccessException("we cant do factorial");
            return 0L;
        }
        long toReturn = 1L;
        for (int i = 1; i<=n; i++){
            toReturn*=i;
        }

        return toReturn;
    }
}
