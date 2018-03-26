package algorithms;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> doFizzBuzz(int n) {
        
        List<String> toReturn = new ArrayList<>();

        for(int i=1;i <= n; i++){
            String result = toword(i,3,"Fizz")+toword(i,5,"Buzz");

            if("".equals(result)){
                toReturn.add(Integer.toString(i));
            } else {
                toReturn.add(result);

            }

        }
        return toReturn;
    }

    private static String toword(int value, int divisor, String word){
        return value % divisor == 0 ? word : "";
    }
}
