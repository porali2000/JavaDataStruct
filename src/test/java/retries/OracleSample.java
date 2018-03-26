package retries;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class OracleSample {

    @Test
    public void testArmStrong() {

        int input = 153;
        int inputActual = input;
        double sum = 0;
        int n = (int) (Math.log10(input) + 1);


        while (input % 10 > 0) {
            sum =  (sum + Math.pow(input % 10, n));
            input = input / 10;
        }
        System.out.println((sum == inputActual) ? "Yes":"No");
        System.out.println(3*3*3);


    }

    private int pfa(int input, int size) {
        return (int) Math.pow(input,size);
    }

    @Test
    public void findSubsetsum() {
        boolean isSubsetfound = false;

        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int i = 0;
        while(i < set.length) {
            int j = i;
            while(j < set.length) {
                if (set[i] + set[j] == sum) {
                    isSubsetfound = true;
                }
                j++;
            }
            i++;
        }

        System.out.println(isSubsetfound);
    }

    @Test
    public void testAnagram() {
        String a = "ate";
        String b = "eat";

        List<Map> list = new ArrayList<>();
        Set<Map> set = new HashSet<>();
        Map<Character, Character> map = new TreeMap();
        Map<Character, Character> map2 = new TreeMap();
        for (char c: a.toCharArray()) {
            map.put(c,c);

        }

        for (char c: b.toCharArray()) {
            map2.put(c,c);
        }

        Assert.assertEquals(map,map2);

        list.add(map);
        list.add(map2);

        set.add(map);
        set.add(map2);


        System.out.println(list);
        System.out.println(set);
    }


    public int hashcode(String value) {
        int hash = 0;
        int x = 32;
        char[] chars = value.toCharArray();
        int i = 0;
        while(i < chars.length) {
            hash =  chars[i]  + hash;
            i++;
        }
        return hash;
    }
}
