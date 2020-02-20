package sorting;

public class SelectionSort extends Sort {

    public static void main(String[] args) {
        print(sort(given));
        print(sort(expected));
    }


    public static int[] sort(int[] toSort) {
        int[] toReturn = new int[toSort.length];
        int l = toSort.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while (j < l) {
            int min = toSort[i];
            while (i < l) {
                if (min > toSort[i]) {
                    min = toSort[i];
                     k =i;
                }
                i++;
            }
            toReturn[j] = min;
            toSort[k] = toSort[j];
            toSort[j] = min;
            j++;
            i = j;
            k = 0;
        }
        return toReturn;
    }
}
