//4344. 평균은 넘겠지
package BaekjoonOnlineJudge.Implementation;
import java.util.Scanner;

public class boj_4344{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc, pp;
        int[] seq;

        int tmp, sum, mean;

        tc = sc.nextInt();
        for(int i = 0; i < tc; i++){
            pp = sc.nextInt();
            tmp = 0; sum = 0; mean = 0;
            seq = new int[pp];
            for(int j = 0; j < pp; j++){
                tmp = sc.nextInt();
                sum += tmp;
                seq[j] = tmp;
            }

            for(int j = 0; j < pp; j++){
                if(seq[j]*pp > sum) mean++;
            }

            System.out.printf("%.3f%%\n", (mean*100)/((float)pp));
        }
        sc.close();
    }
}