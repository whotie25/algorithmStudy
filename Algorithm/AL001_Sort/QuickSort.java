package AL001_Sort;

public class QuickSort {
    public static void sort(int[] seq) {
        divide(seq, 0, seq.length - 1);   
    }

    private static void divide(int[] seq, int lowIdx, int highIdx) {
        if(lowIdx >= highIdx) return;

        int pivotIdx = pivotSort(seq, lowIdx, highIdx);

        divide(seq, lowIdx, pivotIdx - 1);
        divide(seq, pivotIdx + 1, highIdx);
    }

    private static int pivotSort(int[] seq, int left, int right) {
        int lowIdx = left;
        int highIdx = right;
        int pivot = seq[left];

        while(lowIdx < highIdx) {
            while(seq[highIdx] > pivot && lowIdx < highIdx) highIdx--;
            while(seq[lowIdx] <= pivot && lowIdx < highIdx) lowIdx++;

            swap(seq, lowIdx, highIdx);
        }

        swap(seq, left, lowIdx);

        return lowIdx;
    }

    private static void swap(int[] seq, int i, int j) {
        int tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }

    public static String toString(int[] seq) {
        if(seq.length == 0) return "[]";
        
        String str = "[";
        for(int i = 0; i < seq.length - 1; i++) {
            str += seq[i] + ", ";
        }
        str += seq[seq.length-1] + "]";

        return str;
    }

    public static void main(String[] args) {
        int[] seq_A = {4, 1, 6, 9, 2, 5, 3, 8, 7};
        sort(seq_A);
        System.out.printf("Sorted : %s\n", toString(seq_A));
    }
}