//1676. 팩토리얼 0의 개수
package BaekjoonOnlineJudge.Mathematics;
import java.util.Scanner;

public class boj_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();

        if(x == 0 || x == 1) {
            System.out.println(0);
            return;
        }

        int cntTwo = 0, cntFive = 0;
        for(int i = 2; i <= x; i++) {
            int tmp = i;
            while(tmp%2 == 0) {
                cntTwo++;
                tmp /= 2;
            }
            while(tmp%5 == 0) {
                cntFive++;
                tmp /= 5;
            }
        }

        System.out.println((cntTwo>cntFive)?cntFive:cntTwo);
    }
}
