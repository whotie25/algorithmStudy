//10814. 나이순 정렬
package BaekjoonOnlineJudge.Sort;
import java.util.Scanner;

public class boj_10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rep = sc.nextInt();
        int[][] idxArr = new int[rep][2];
        String[] nameArr = new String[rep];
        for(int i = 0; i < rep; i++) {
            idxArr[i][0] = sc.nextInt();
            idxArr[i][1] = i;
            nameArr[i] = sc.next();
        }
        sc.close();

        mergeSort(idxArr);

        for(int i = 0; i < rep; i++) {
            System.out.println(idxArr[i][0] + " " + nameArr[idxArr[i][1]]);
        }
    }

    private static int[][] sorted;

    public static void mergeSort(int[][] arr) {
        if(arr.length == 0) return;

        sorted = new int[arr.length][arr[0].length];
        divide(arr, 0, arr.length - 1);
    }

    private static void divide(int[][] arr, int left, int right) {
        if(left == right) return;

        int mid = (left+right)/2;
        divide(arr, left, mid);
        divide(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[][] arr, int left, int mid, int right) {
        int l = left;
        int r = mid+1;
        int idx = left;

        while(l <= mid && r <= right) {
            if(arr[l][0] <= arr[r][0]) {
                sorted[idx][0] = arr[l][0];
                sorted[idx][1] = arr[l][1];
                idx++; l++;
            } else {
                sorted[idx][0] = arr[r][0];
                sorted[idx][1] = arr[r][1];
                idx++; r++;
            }
        }

        if(l > mid) {
            while(r <= right) {
                sorted[idx][0] = arr[r][0];
                sorted[idx][1] = arr[r][1];
                idx++; r++;
            }
        } else {
            while(l <= mid) {
                sorted[idx][0] = arr[l][0];
                sorted[idx][1] = arr[l][1];
                idx++; l++;
            }
        }

        for(int i = left; i <= right; i++) {
            arr[i][0] = sorted[i][0];
            arr[i][1] = sorted[i][1];
        }
    }
}
