package Java.AL001_Sort;

public class BubbleSort {
    public static void sort(int[] seq) {
        for(int i = 1; i < seq.length; i++) {
            for(int j = 0; j < seq.length - i; j++) {
                if(seq[j] > seq[j+1]) {
                    int tmp = seq[j+1];
                    seq[j+1] = seq[j];
                    seq[j] = tmp;
                }
            }
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
        sort(seq_A);
        System.out.println(toString(seq_A));
    }
}