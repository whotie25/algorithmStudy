//1181. 단어 정렬
package BaekjoonOnlineJudge.Sort;
import java.util.Scanner;

public class boj_1181 {
    public static void sort(String[] arr) {
        if(arr.length == 0) return;

        sorted = new String[arr.length];
        divide(arr, 0, arr.length - 1);
        sorted = null;
    }

    private static String[] sorted;

    private static void divide(String[] arr, int left, int right) {
        if(left == right) return;

        int mid = (left + right)/2;
        
        divide(arr, left, mid);
        divide(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(String[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid+1;
        int idx = left;

        while(l <= mid && r <= right) {
            if(arr[l].length() < arr[r].length()) {
                sorted[idx] = arr[l];
                idx++; l++;
            } else if(arr[l].length() > arr[r].length()) {
                sorted[idx] = arr[r];
                idx++; r++;
            } else /* same length */ {
                boolean isSame = true;
                for(int i = 0; i < arr[l].length(); i++) {
                    if(arr[l].charAt(i) < arr[r].charAt(i)) {
                        sorted[idx] = arr[l];
                        idx++; l++; isSame = false;
                        break;
                    } else if(arr[l].charAt(i) > arr[r].charAt(i)) {
                        sorted[idx] = arr[r];
                        idx++; r++; isSame = false;
                        break;
                    }
                }
                
                if(isSame) {
                    sorted[idx] = arr[l];
                    idx++; l++;
                }
            }
        }

        if(l > mid) {
            while(r <= right) {
                sorted[idx] = arr[r];
                idx++; r++;
            }
        } else {
            while(l <= mid) {
                sorted[idx] = arr[l];
                idx++; l++;
            }
        }

        for(int i = left; i <= right; i++) arr[i] = sorted[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strArr = new String[n];
        for(int i = 0; i < n; i++) {
            strArr[i] = sc.next();
        }
        sc.close();

        sort(strArr);

        String tmp = null;
        for(int i = 0; i < n; i++) {
            if(!strArr[i].equals(tmp)) {
                System.out.println(strArr[i]);
                tmp = strArr[i];
            }
        }
    }
}
