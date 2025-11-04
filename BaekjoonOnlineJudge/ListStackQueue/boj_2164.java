//2164. 카드2
package BaekjoonOnlineJudge.ListStackQueue;
import java.util.Scanner;
import java.util.ArrayDeque;

public class boj_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 1; i <= size; i++) {
            ad.add(i);
        }

        while(true) {
            if(ad.size() == 1) break;
            else ad.remove();

            if(ad.size() == 1) break;
            else ad.add(ad.pop());
        }

        System.out.println(ad.pop());
    }
}
