package retries;

import org.junit.Test;

import java.util.*;

public class SetJava {
    @Test
    public void testEqualsAndCompare(){
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1.equals(i2));
//        System.out.println(i1.compareTo(i2));
        System.out.println(i1 == i2);

        String s1 = "Hi";
        String s2 = "Hii";
        System.out.println();


//        System.out.println();
        System.out.println(s1.equals(s2));
//        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.compareTo(s2));
        System.out.println(s1 == s2);
    }

    @Test
    public void testHashSet() {

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(3);
        hashSet.add(8);



        System.out.println(hashSet);
        System.out.println(hashSet.size());
        System.out.println(hashSet.contains(3));

    }

    @Test
    public void testLinkedHashSet() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        linkedHashSet.add(122);
        linkedHashSet.add(1);

        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.size());
    }

    @Test
    public void testTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(30);
        treeSet.add(10);

        System.out.println(treeSet.ceiling(5));
        System.out.println(treeSet.floor(5));


        System.out.println(treeSet.tailSet(9));
        System.out.println(treeSet);
        System.out.println(treeSet.size());
    }
}
