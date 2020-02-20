package sorting;

public class QuickSort extends Sort {
    public static void main(String[] args) {
        print(sort(given));
        assertResult(sort(given));
    }

    public static int[] sort(int[] toSort) {
        if(null == toSort || toSort.length < 2) {
            return toSort;
        }
        int pivot = toSort[0];
        int[] lower = new int[0];
        int[] higher = new int[0];

        int i = 0;
        while (i < toSort.length) {
            if( toSort[i] < pivot) {
                lower = add(lower, toSort[i]);
            } if( toSort[i] > pivot) {
                higher = add(higher, toSort[i]);
            }
            i++;
        }

        return agg(sort(lower), pivot, sort(higher));
    }

    private static int[] agg(int[] lower, int pivot, int[] higher) {
        int i = 0;
        int[] toReturn = new int[lower.length + higher.length + 1];
        int j = 0;
        while ( j <  lower.length) {
            toReturn[i] = lower[j];
            i++;
            j++;
        }
        toReturn[i] = pivot;
        i++;
        int k = 0;
        while ( k <  higher.length) {
            toReturn[i] = higher[k];
            i++;
            k++;
        }
        return  toReturn;
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
