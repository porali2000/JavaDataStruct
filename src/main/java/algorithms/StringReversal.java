package algorithms;

public class StringReversal {

    public static String reverseStringLinear(String actual){
        StringBuffer stringBuffer = new StringBuffer(actual.length());
        for(int i = actual.length()- 1; i >= 0 ; i--) {
            stringBuffer.append(actual.charAt(i));
        }

        return stringBuffer.toString();
    }

    public static String reverseEfficiently(String s){
        StringBuffer stringBuffer = new StringBuffer(s);

        for (int i = 0; i <= stringBuffer.length()/2; i++){
            char temp = stringBuffer.charAt(i);
            int otherEndIndex = stringBuffer.length() - 1 - i;
            char otherEnd = stringBuffer.charAt(otherEndIndex);
            stringBuffer.setCharAt(i, otherEnd);
            stringBuffer.setCharAt(otherEndIndex,temp);
        }
        return stringBuffer.toString();
    }
}
