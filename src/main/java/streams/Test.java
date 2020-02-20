package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] as = {1,2,3,4};
        List<Integer> iList  = new ArrayList<>();
        Arrays.stream(as).parallel().forEach(x -> iList.add(x));

        iList.parallelStream().filter(x -> x == 3).sorted().forEach(System.out::println);
    }
}