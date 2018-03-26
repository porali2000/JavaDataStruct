package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class CArrayTest {

    @Test
    public void testcAray() {
        CArray<Integer> cArray = new CArray<>();
        cArray.add(1);
        cArray.add(2);
        cArray.add(4);
        cArray.delete(5);
        cArray.insert(3,3);
        Assert.assertTrue(cArray.find(3));
        System.out.println(cArray);
    }


}
