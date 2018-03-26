import java.lang.reflect.Array;
import java.util.ArrayList;

public class demo {

    public static void main(String[] args) {
        int[] vals = {1,2,5,3,4,7,3,2,1,3,8,7,4,6,3,6,3};

        int minIndex =0;

        for (int i=0; i < vals.length; i++) {
            if(i+1 == vals.length) return;

            if (vals[i] > vals[i+1]) {
                int temphold = vals[i];
                vals[i] = vals[i+1];
                vals[i+1] = temphold;
            }
        }
    }
}
