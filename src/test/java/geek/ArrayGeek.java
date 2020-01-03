package geek;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntBinaryOperator;

public class ArrayGeek {
    Integer[] arrays = {1, 2, 3, 4, 5, 6};
    Integer[] result;
    int rotate = 1;
    int d = rotate;
    int toFind = 4;

    private void printArrray(Object[] objects) {
        System.out.println(Arrays.asList(objects));
    }

    private void printArrray(Object[] o1, Object[] o2) {
        System.out.print(Arrays.asList(o1));
        System.out.print("   ");
        System.out.println(Arrays.asList(o2));
    }

    @Test
    public void testArrayrotation() {
        int i = 0;
        int r = arrays.length - rotate;
        result = new Integer[arrays.length];
        while (i < arrays.length) {

            if (r == arrays.length) {
                r = 0;
            }
            result[i] = arrays[r];

            i++;
            r++;
        }
    }

    @Test
    public void testSearchSortedRoatatedArray() {
        testArrayrotation();
        //result = arrays;
        System.out.println(Arrays.asList(result));

        System.out.println(binarySearch(5, result));


    }

    private boolean binarySearch(int value, Integer[] source) {
        if (source.length < 1) {
            return false;
        }

        if (value == source[0 + rotate]) {
            return true;
        }
        if (value != source[0 + rotate] && source.length == 1) {
            return false;
        }
        int mid = source.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[source.length - mid];

        if (value > source[0 + rotate]) {
            int i = 0;
            int r = mid - rotate;
            while (i < right.length) {
                right[i] = source[r];
                i++;
                r++;
            }
            printArrray(right, source);
            return binarySearch(value, right);
        } else {
            int i = 0;
            int r = 0 + rotate;
            while (i < left.length) {
                left[i] = source[r];
                r++;
                i++;
            }
            printArrray(left, source);
            return binarySearch(value, left);
        }
    }


    private boolean binarySearchNormal(int value, Integer[] source) {
        if (source.length < 1) {
            return false;
        }

        if (value == source[0]) {
            return true;
        }
        if (value != source[0] && source.length == 1) {
            return false;
        }
        int mid = source.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[source.length - mid];

        if (value > source[0]) {
            int i = 0;
            int r = mid;
            while (i < right.length) {
                right[i] = source[r];
                i++;
                r++;
            }
            printArrray(right, source);
            return binarySearchNormal(value, right);
        } else {
            int i = 0;
            int r = 0;
            while (i < left.length) {
                left[i] = source[r];
                r++;
                i++;
            }
            printArrray(left, source);
            return binarySearchNormal(value, left);
        }

    }

    @Test
    public void testSum() {
        printArrray(arrays);

        int sum = 5;

        int i = 0;
        while (i < arrays.length) {
            int x = sum - arrays[i];
            int j = 0;
            while (j < arrays.length) {
                if (x == arrays[j]) {
                    System.out.println(arrays[i] + " --> " + arrays[j]);
                }
                j++;
            }
            i++;
        }
    }

    @Test
    public void testXor() {
        int n = 101;
        int sum = 0;
        int total = 0;
        Integer[] source = new Integer[n];
        for (int i = 0; i < n; i++) {
            if (n == 4) continue;
            source[i] = n;
        }
        for (int i = 0; i < n; i++) {
            total = total ^ i;
            sum = sum ^ n;
            System.out.print(n);
            System.out.print("      ");
            System.out.println((total) ^ (sum));
        }
    }


    @Test
    public void testTriplet() {
        Integer[] arr = {3, 1, 4, 6, 5};
        int i = 0;
        while (i < arr.length) {
            int j = i + 1;
            while (j < arr.length) {
                int k = i + 1;
                while (k < arr.length) {
                    if ((arr[i] * arr[i]) + (arr[j] * arr[j]) == (arr[k] * arr[k])) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

    }

    @Test
    public void testTripletO2n() {
        Integer[] arr = {3, 1, 4, 6, 5};
        int i = 0;
        while (i < arr.length) {
            arr[i] = arr[i] * arr[i];
            i++;
        }
        System.out.println(Arrays.asList(arr));
        Arrays.sort(arr);
        int j = arr.length - 1;
        while (j > arr.length - 3) {
            if (arr[j] == arr[j - 1] + arr[j - 2]) {
                System.out.println(Math.sqrt(arr[j - 2]) + "  " + Math.sqrt(arr[j - 1]) + "  " + Math.sqrt(arr[j]));
            }
            j--;
        }
    }

    @Test
    public void testArrayVisit() {
        Integer[] arr = {3, 1, 4, 6, 5};

        Integer[] vistRec = new Integer[arr.length];

        int i = 0;
        while (i < arr.length) {
            if (null == vistRec[i] || vistRec[i] < 1) {
                vistRec[i] = (null == vistRec[i]) ? 1 : vistRec[i] + 1;
                System.out.println(arr[i]);
            }
            i++;
        }

        printArrray(vistRec);

    }


    @Test
    public void testVisitOnce() {
        int[] arr = {3, 1, 4, 6, 5};
        System.out.println(visit(arr.length));
    }

    private boolean visit(int length) {
        System.out.println(length);
        if (length < 1) {
            return false;
        } else
            return visit(length - 1);
    }

    @Test
    public void testKeyPairs() {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Integer[] array = new Integer[n];
            int i = 0;
            while (i < n) {
                array[i] = sc.nextInt();
            }

            Arrays.sort(array, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            int j = 0;
            while (j < k) {
                System.out.print(array[j] + " ");
                j++;
            }
            System.out.println();

            tc--;
        }
    }

    @Test
    public void testBinary() {
        int index = 6;
        int m = 3;
        int n = 3;

        String s = Integer.toBinaryString(m);
        String s1 = "";
        while (n > 0) {
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    s1 = s1 + "01";
                }
                if (c == '1') {
                    s1 = s1 + "10";
                }
                s = s1;
            }
            n--;
        }

        System.out.println(s.charAt(index));
    }

    @Test
    public void testClosest() {
//        Integer[] arr = {10, 50, 12, 100};
        Integer[] arr = {5, 4, 3, 2};
        System.out.println(getCloset(arr));
    }

    private List<ArrayList> getCloset(Integer[] arr) {
        List<ArrayList> list = new ArrayList<>();
        Integer d = null;
        ArrayList<Integer> arrayList = null;
        for (Integer x : arr) {
            for (Integer y : arr) {
                if (x != y) {
                    if (d == null) d = Math.abs(x - y);
                    System.out.println(d);

                    if (d >= Math.abs(x - y)) {
                        d = Math.abs(x - y);
                        arrayList = new ArrayList();
                        arrayList.add(x);
                        arrayList.add(y);
                        list.add(arrayList);

                    }
                }
            }
        }

        return list;
    }

    @Test
    public void testWordReverse() {
        String s1 = "Hello World";
        String s2 = "Geeks for Geeks";
        wordReverse(s1);
        wordReverse(s2);
    }

    private void wordReverse(String s1) {
        Stack<Character> stack = new Stack<>();
        for (char c : s1.toCharArray()) {
            if (c == ' ') {
                while (!stack.empty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(c);
            } else {
                stack.push(c);
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }


    @Test
    public void testPalindrome() {
        int n = 489;
        System.out.println(palidrome(n));
    }

    private int palidrome(int n) {
        int left = 0;
        int right = 0;

        int i = n;
        int j = n;
        while (!findPalidrome(i)) {
            left = i;
            i--;
        }

        while (!findPalidrome(j)) {
            right = j;
            j++;
        }


        System.out.println(left);
        System.out.println(right);
        return (n - left < right - n) ? left : right;
    }

    private boolean findPalidrome(int n) {
        String s = String.valueOf(n);
        System.out.println(s);

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    @Test
    public void testAmazonStringRepeat() {
        String s = "romeo at the theatre was an romeo who is a successful romeo";
//        String s = "romeo at the theatre was an who is a successful";
        List<String> toExclude = new ArrayList<>();
        toExclude.add("and");
        toExclude.add("at");
        toExclude.add("the");
        toExclude.add("an");
        toExclude.add("is");
        toExclude.add("is");
        toExclude.add("was");
        toExclude.add("who");
        toExclude.add("a");

        List<String> toReturn = new ArrayList<>();
        int max = 0;
        Set<String> set = new HashSet<>();

        for (String x : s.split(" ")) {
            if (!toExclude.contains(x)) {
                toReturn.add(x);
            }
        }
        Collections.sort(toReturn);

        for (String x : toReturn) {
            int frequency = Collections.frequency(toReturn, x);
            if (frequency >= max) {
                max = frequency;
                set.add(x);
            }
        }

        System.out.println(set);
    }

    @Test
    public void testAmazonStringRepeat1() {
        List<String> toExclude = new ArrayList<>();
        toExclude.add("and");
        toExclude.add("at");
        toExclude.add("the");
        toExclude.add("an");
        toExclude.add("is");
        toExclude.add("is");
        toExclude.add("was");
        toExclude.add("who");
        toExclude.add("a");
//        String s = "romeo at the theatre was an romeo who is a successful romeo";
        String s = "romeo at the theatre was an who is a successful";
        String[] split = s.split(" ");
        Arrays.sort(split);

        int count = 0;
        int max = 0;
        String previous = "";
        String[] toReturn = new String[split.length];

        int i = 0;
        for (String x : split) {

            if (x == null || toExclude.contains(x)) {
                continue;
            } else {
                if (previous.equals(x)) {
                    count = count + 1;
                } else {
                    if (count >= max && !previous.isEmpty()) {
                        max = count;
                        toReturn[i] = previous;
                        i++;
                    }
                    count = 1;
                }
            }

            System.out.println(x + "    " + previous + "    count: " + count+ "    max : " + max);
            previous = x;

        }


        System.out.println(Arrays.asList(toReturn));
    }

    @Test
    public void testRepeat() {
        String[] string = {"b","a","a","b","b","a"};

        int i = 0;
        int freq = 0;
        int max = 0;

        Stack<String> stack = new Stack<>();
        Arrays.sort(string);

        if (string.length < 2) {
            return;
        }
        String previous = string[0];

        while (i <  string.length) {

            System.out.print(string[i]);
            System.out.print("  ");
            System.out.print(previous);
            System.out.print("  ");
            System.out.print(freq);
            System.out.print("  ");
            System.out.print(max);
            System.out.println();



            if (previous.equals(string[i])) {
                freq++;
            }



            if (freq >= max) {
                max = freq;
            }

            if (!previous.equals(string[i]) && freq == max) {
                System.out.println(previous);
            }

            if (!previous.equals(string[i])) {

                freq = 1;
                previous = string[i];
            }




            i++;

        }
        System.out.println(stack);
     }

     class Holder {
        public String key;
        public int value;

         @Override
         public String toString() {
             return "["+key+":"+value+"]";
         }
     }

    @Test
    public void testRepeat2() {
        String[] string = {"b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a",
                "b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a","b", "a", "a", "b", "b", "a"};

        Map<Integer, String> map1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o2.hashCode() - o1.hashCode();
            }
        });
        Map<String, Integer> map2 = new HashMap();

        for (String x: string) {
            if (map2.containsKey(x)) {
                map2.put(x, map2.get(x) + 1);
            } else {
                map2.put(x, 1);
            }
        }
        int max = 0;
        List list = new ArrayList();
        for (Integer x: map2.values()) {


        }

        System.out.println(map2);
        System.out.println(map1);

    }

    @Test
    public void testRepeated3() {
        String[] str = {"a", "a"};
        String[] str1 = {"a", "a", "b", "b", "b", "b"};
        String[] str2 = {"a", "a", "a", "a", "b", "b"};
        String[] str3 = {"a", "a", "a", "b", "b", "b"};

        testRepe(str);
        testRepe(str1);
        testRepe(str2);
        testRepe(str3);

    }

    private void testRepe(String[] str) {

        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for (String x: str) {
            if (set.contains(x)) {
               map.put(x, (map.containsKey(x)) ? map.get(x) + 1 : 1);
            } else {
                set.add(x);
            }
        }

        int max = 0;
        Set<String> set2 = new HashSet<>();
        for (String x: set) {
            if (map.get(x) > max) {
                max = map.get(x);
                set2.clear();
                set2.add(x);
            }
            if (map.get(x) == max) {
                set2.add(x);
            }
        }

        System.out.println(set2);
    }
}


