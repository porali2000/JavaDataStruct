package arrays;

public class AddArray extends Arr {
    public static void main(String[] args) {
        print(add(given, 110));
    }

    static int[] add(int[] arrays, int value) {
        int[] temp = new int[arrays.length + 1];
        int i =0;
        while (i < arrays.length) {
            temp[i] = arrays[i];
            i++;
        }
        temp[i] = value;
        return temp;
    }
}
