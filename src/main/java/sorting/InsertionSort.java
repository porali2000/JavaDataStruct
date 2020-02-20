package sorting;

public class InsertionSort extends Sort {
    public static void main(String[] args) {
        print(sort(given));
    }

    public static int[] sort(int[] toSort) {
        int l = toSort.length - 1;
        int i = 0;
        int j = 0;
        while (i < l) {
            if(toSort[i] > toSort[i + 1] ) {
                int temp = toSort[i + 1];
                toSort[i + 1] = toSort[i];
                toSort[i] = temp;
                i=0;
            } else {
                i++;
            }
            j++;
        }
        System.out.println(j);
        return toSort;
    }
}
