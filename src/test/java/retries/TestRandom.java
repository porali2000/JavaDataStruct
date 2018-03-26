package retries;

import org.junit.Test;

public class TestRandom {

    @Test
    public void testLongest() {

        String sen = "a beau!&tiful sentence^&!";
        int length = -1;
        String longest = "";
        String[] split = sen.split(" ");
        for (String x : split) {
            char[] chars = x.toCharArray();
            char[] temp = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                if (((int) chars[i] >= 97 && (int) chars[i] <= 122)
                || ((int) chars[i] >= 65 && (int) chars[i] <= 90)) {
                    temp[i] = chars[i];
                }
            }
            System.out.println(temp);

        }

    }
}
