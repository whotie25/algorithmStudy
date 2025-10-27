//1427. 소트인사이드
package BaekjoonOnlineJudge.Sort;
import java.util.Scanner;

public class boj_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String getStr = sc.next();
        sc.close();

        int[] freq = new int[10];
        for(int i = 0; i < getStr.length(); i++) {
            char tmp = getStr.charAt(i);
            freq[tmp-48]++;
        }

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < freq[9-i]; j++) {
                System.out.print(9-i);
            }
        }
    }
}
