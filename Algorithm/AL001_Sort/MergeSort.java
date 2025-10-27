package AL001_Sort;

public class MergeSort {
    private static int[] sorted;
    private static int d = 0; //delete later
    private static int m = 0; //delete later

    public static void sort(int[] seq) {
        if(seq.length == 0) return;

        sorted = new int[seq.length];
        divide(seq, 0, seq.length - 1);
        sorted = null;
    }

    private static void divide(int[] seq, int left, int right) {
        System.out.printf("D%d\n", ++d); //delete later
        if(left == right) return;

        int mid = (left + right)/2;

        divide(seq, left, mid);
        divide(seq, mid+1, right);

        merge(seq, left, mid, right);
        System.out.printf(" : %s\n", toString(seq)); //delete later
    }

    private static void merge(int[] seq, int left, int mid, int right) {
        System.out.printf("M%d", ++m); //delete later
        int l = left;
        int r = mid + 1;
        int idx = left;

        while(l <= mid && r <= right) {
            if(seq[l] <= seq[r]) {
                sorted[idx] = seq[l];
                idx++; l++;
            } else { 
                sorted[idx] = seq[r];
                idx++; r++;
            }
        }

        if(l > mid) {
            while(r <= right) {
                sorted[idx] = seq[r];
                idx++; r++;
            }
        } else {
            while(l <= mid) {
                sorted[idx] = seq[l];
                idx++; l++;
            }
        }

        for(int i = left; i <= right; i++) seq[i] = sorted[i];
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
        System.out.printf("\nSorted : %s\n", toString(seq_A));
    }
}
