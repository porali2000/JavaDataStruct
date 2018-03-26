import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestDataStructure {

    @Test
    public void testAraryCopy(){
        int[] actual = {12,23};
        int[] wanted = new int[actual.length + 2];
        System.arraycopy(actual,0,wanted,0,actual.length);
        wanted[2] = 10;
        for (int value: wanted){
            System.out.print( value+ ", ");
        }
    }

    @Test
    public void testLinkedList(){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(33);
        list.add(33);
        list.add(33);
        list.add(33);
        list.add(33);
        list.add(43);list.add(33);

        list.sort(new ReverseOrdering());



        System.out.println(list.peek());
        list.remove(list.indexOf(33));

        System.out.println(list.getLast());

        System.out.println(list);
    }

    @Test
    public void testQueue(){
        Queue queue = new LinkedList();
        queue.add("fisrt");
        queue.add("second");
        queue.add("third");
        queue.add("fourth");
        queue.add("six");

        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.poll());

    }

    @Test
    public void testBinarySearchTree(){
        TreeNode<Integer> parent = new TreeNode<Integer>(33);
        BinarySearchTree bst = new BinarySearchTree(parent);
        Assert.assertTrue(bst.search(33));

        bst.insert(34);
        bst.insert(35);
        bst.insert(23);bst.insert(4);
        bst.insert(44);bst.insert(24);
        bst.insert(54);



        Assert.assertTrue(bst.search(34));

        bst.delete(34);
        Assert.assertFalse(bst.search(34));

    }

    @Test
    public void testMap(){
        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        map1.put(10,"love");
        map1.put(2, "welcome");
        map1.put(1, " good bye");
        System.out.println(map1);



        Set<Integer> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(10);
        set1.add(2);
        set1.add(1);
        set1.add(6);
        set1.add(4);
        set1.add(7);
        set1.add(9);
        set1.add(0);
        set2.add("a");
        set2.add("e");
        set2.add("d");

        for(int value:map1.keySet()){
            System.out.print(" "+value+",");
        }
        System.out.println();

        System.out.println(set1);
        System.out.println(set2);

    }
}
