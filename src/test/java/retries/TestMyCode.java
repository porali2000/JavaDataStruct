package retries;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestMyCode {

    @Test
    public void testManager(){


        Map<String,String> map = new HashMap<>();
        map.put("A","C");
        map.put("B","C");
        map.put("C","F");
        map.put("D","E");
        map.put("E","F");
        map.put("F","F");


        Assert.assertEquals("F", MyCode.findReportees(map));
    }
}
