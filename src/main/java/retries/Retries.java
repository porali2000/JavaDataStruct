package retries;

import java.util.*;

public class Retries {


    public static void main(String[] args) {
        Retries retries = new Retries();

        retries.dicitionary();

    }

    public void enumuretaion() {
        Enumeration enumeration;
        Vector vector = new Vector();
        vector.add("S");
        vector.add(1);
        vector.add(vector);
        vector.add(new Integer(23));
        vector.add(new ArrayList<>());
        System.out.println(vector.capacity());
        enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    public void bitSet() {
        BitSet biteSet = new BitSet();
        BitSet biteSet2 = new BitSet();
        biteSet.set(1);
        biteSet.set(3);
        biteSet.set(6);
        biteSet.set(10);
        biteSet.set(11);
        System.out.println(biteSet);
        System.out.println(biteSet.nextClearBit(3));
        System.out.println(biteSet.nextClearBit(22));
    }

    public void stack() {
        Stack stack = new Stack();
        stack.add(3);
        stack.add(5);
        stack.add(1);
        stack.add(6);
    }

    public void dicitionary() {
        Dictionary dictionary = new Hashtable();
        dictionary.put(1,100);
        System.out.println(dictionary);
    }


}