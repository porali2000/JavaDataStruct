package sorting;

public class MergeSort extends Sort {
    public static void main(String[] args) {
        print(split( given));
    }

    public static int[] sort(int[] toSort) {
        int l = toSort.length - 1;
        int i = 0;
        int j = 0;
        return toSort;
    }

    static int[] split(int[] toSplit){
        if (null == toSplit || toSplit.length < 2) {
            return toSplit;
        }

        int  mid = toSplit.length / 2;
        int[] left = new int[mid];
        int[] right = new int[toSplit.length - mid];

        int i = 0;
        while (i < mid) {
            left[i] = toSplit[i];
            i++;
        }

        int  j = 0;
        while (j + mid < toSplit.length) {
            right[j] = toSplit[j+mid];
            j++;
        }

        return merge(split(left), split(right));
    }

    static int[] merge(int[] first, int[] second) {
        int[] toReturn = new int[first.length + second.length];
            if(first[first.length -1] > second [0]) {
                int i  = 0;
                while (i < second.length ) {
                    toReturn[i] = second[i];
                    i++;
                }
                int j  = 0;
                while (j < first.length) {
                    toReturn[i + j] = first[j];
                    j++;
                }
             } else {
                int j  = 0;
                while (j < first.length ) {
                    toReturn[j] = first[j];
                    j++;
                }
                int i  = 0;
                while (i < second.length) {
                    toReturn[i + j] = second[i];
                    i++;
                }
            }
        return toReturn;
    }
}
