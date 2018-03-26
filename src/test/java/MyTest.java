import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyTest {

    @Test
    public void testBinarySearchTree(){
        TreeNode<Integer> n0 = new TreeNode<Integer>(10, null);
        TreeNode<Integer> n1 = new TreeNode<Integer>(5, n0);
        TreeNode<Integer> n2 = new TreeNode<Integer>(12, n0);
        n0.addLeftChild(n1);
        n0.addRightChild(n2);

        BinarySearchTree bst = new BinarySearchTree(n0);

        Assert.assertTrue(bst.contains(12));
        Assert.assertFalse(bst.contains(15));
    }

    @Test
    public void testshortest(){
        Set<Integer> set = new HashSet();

        int inout = 6;

        int[] actual = {1,2,4,5,7};
        for (int i=0; i< actual.length;i++) {
            set.add(Math.abs(actual[i] - inout));

        }

        Set<Integer> result = new HashSet<>();

        for (Integer a : set){
            for (int x : actual){
                if ((inout + a) == x) {
                    result.add(x);
                }
                if ((inout - a) == x) {
                    result.add(x);
                }
            }

            break;
        }

        System.out.println(result);
    }
}
