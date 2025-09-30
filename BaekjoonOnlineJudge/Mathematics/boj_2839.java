//2839. 설탕 배달
package BaekjoonOnlineJudge.Mathematics;
import java.util.Scanner;

public class boj_2839{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int trg = sc.nextInt();
        sc.close();

        int ans = 0;

        while(true){
            if(trg % 5 == 0) {
                ans += trg/5;
                break;
            }
            if(trg < 0){
                ans = -1;
                break;
            }
            trg -= 3; ans++;
        }

        System.out.print(ans);
    }
}