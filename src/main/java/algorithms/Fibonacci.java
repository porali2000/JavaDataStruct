package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {

    public List<Integer> dofibonacci(int n){
        int prevoius=0;
        int next = 1;
        List<Integer> toReturn = new ArrayList<>();

        for(int i=1; i <= n; i++) {
            toReturn.add(prevoius);
            int new_next = sumTwoValues(prevoius, next);
            prevoius = next;
            next = new_next;
        }

        return toReturn;
    }

    public Integer sumTwoValues(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    public Long sumTwoValues(long firstValue, long secondValue) {
        return firstValue + secondValue;
    }

    public Map<Integer, Long> dofibonacciForNth(int n){
        long prevoius=0;
        long next = 1;
        Map<Integer, Long> toReturn = new HashMap<>();

        for(int i=1; i <= n; i++) {
            toReturn.put(n,Long.valueOf(next));
            long new_next = sumTwoValues(prevoius, next);
            prevoius = next;
            next = new_next;
        }

        return toReturn;
    }


    private Map<Integer,Long> fibCache = new HashMap<>();

    public   long fibN(int n){
        if(n < 0 ) {
            throw new IllegalArgumentException("connaot do fib");
        }
        fibCache.put(0,0L);
        fibCache.put(1,1L);

        return recursiveFibN(n);
    }

    public long recursiveFibN(int n) {
        if(fibCache.containsKey(n)) {
            return fibCache.get(n);
        }
        long value = recursiveFibN(n - 1) + recursiveFibN(n - 2);
        fibCache.put(n, value);
        return value;

    }

}
