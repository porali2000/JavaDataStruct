package geek;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Algorithms {

    Map<Long, Long> hash = new HashMap<>();

    @Test
    public void testFibinocci() {
        System.out.println(fib(55));

    }

    private long fib(long n) {
        if (hash.containsKey(n)) {
            return hash.get(n);
        }
        if (0 == n) return 0;
        if (1 == n) return 1;
        hash.put(n, fib(n - 1) + fib(n - 2));
        return hash.get(n);
    }

    @Test
    public void testBinomialCoefficient() {
        int k = 1;
        int n = 3;
        System.out.println(binomialCoefficient(0, 1));
    }

    private long binomialCoefficient(long k, long n) {
        if (k == 0) return 1;
        if (k == n) return 1;
        return binomialCoefficient( k -1, n -1)+ binomialCoefficient(k, n - 1);
    }


}
