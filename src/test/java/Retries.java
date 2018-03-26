import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Retries {

    @Test
    public void hashtable() {

        String aa = "aaaJavaworld";
        char[] chars = aa.toCharArray();
        String.copyValueOf(chars);

        System.out.println(aa.indexOf("Java"));

    }

    @Test
    public void testString(){
        String a = "hello";
        String b = "java";
        System.out.println(a.length()+b.length());
        System.out.println(a.compareTo(b) > 0 ? "Yes" : "No");
        System.out.print(a.substring(0,1).toUpperCase()+a.substring(1,a.length()) + " ");
        System.out.println(b.substring(0,1).toUpperCase()+b.substring(1,b.length()));
    }

    @Test
    public void testStringOrder() {
        String s = "welcometojava";
        int k = 3;
        SortedSet<String> set = new TreeSet<>();
        for (int i=0; i <= s.length() - k ; i++){
            set.add(s.substring(i, i + k));
        }
        System.out.println(set.first() );
        System.out.println(set.last() );

    }

    @Test
    public void testPallidrome(){
        String A = "madam";
        boolean isPallendrom = true;
        int j = A.length() - 1;
        for (int i=0; i < A.length() / 2 ; i++) {
            if (A.charAt(i) != A.charAt(j)) {
                isPallendrom = false;
                break;
            }
            j--;
        }

        System.out.println(isPallendrom? "Yes" : "No");
    }

    @Test
    public void testAnagrams(){
        String a = "aab";
        String b = "baaa";

        Map<Character,Integer> freq = new HashMap<>();
        for(char x: a.toLowerCase().toCharArray()) {
            freq.put(x, freq.containsKey(x)?freq.get(x) + 1 : 1);
        }


        for(char x: b.toCharArray()) {
            freq.put(x,freq.containsKey(x)?freq.get(x) - 1 : 1);
        }
        System.out.println(freq);
        for(char key: freq.keySet()) {
            if (freq.get(key) != 0) {
                System.out.println(false);
            }
        }

    }



}
