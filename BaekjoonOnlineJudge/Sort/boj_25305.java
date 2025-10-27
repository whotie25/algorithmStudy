//25305. 커트라인
package BaekjoonOnlineJudge.Sort;
import java.util.Scanner;

public class boj_25305 {
    private static int[] sorted;

    public static void mergeSort(int[] seq) {
        if(seq.length == 0) return;

        sorted = new int[seq.length];
        divide(seq, 0, seq.length-1);
        sorted = null;
    }

    private static void divide(int[] seq, int left, int right) {
        if(left == right) return;

        int mid = (left + right)/2;

        divide(seq, left, mid);
        divide(seq, mid+1, right);

        merge(seq, left, mid, right);
    }

    private static void merge(int[] seq, int left, int mid, int right) {
        int l = left;
        int r = mid+1;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] scoreArr = new int[n];
        for(int i = 0; i < n; i++) {
            scoreArr[i] = sc.nextInt();
        }

        sc.close();

        mergeSort(scoreArr);
        
        System.out.println(scoreArr[n-c]);
    }
}
