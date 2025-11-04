package AL001_Sort;

public class InsertionSort {
    public static void sort(int[] seq) {
        for(int i = 1; i < seq.length; i++) {
            int trg = seq[i];

            int j = i-1;
            while(j >= 0 && seq[j] > trg) {
                seq[j+1] = seq[j];
                j--;
            }
            seq[j+1] = trg;
        }
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
        System.out.printf("Original Array : %s\n", toString(seq_A));

        sort(seq_A);
        System.out.printf("Sorted Array :   %s", toString(seq_A));
    }
}
