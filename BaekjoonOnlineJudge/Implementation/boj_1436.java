//1436. 영화감독 숌
package BaekjoonOnlineJudge.Implementation;
import java.util.Scanner;

public class boj_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int tmp = 0;
        for(int i = 0; i < n;) {
            String tmpStr = tmp + "";
            boolean isTri = false;
            for(int j = 0; j < tmpStr.length()-2; j++) {
                if(tmpStr.charAt(j) == '6' && tmpStr.length() - j >= 3) {
                    if(tmpStr.charAt(j+1) == '6') {
                        if(tmpStr.charAt(j+2) == '6') {
                            isTri = true;
                            break;
                        }
                    }
                }
            }

            if(isTri) i++;
            tmp++;
        }

        System.out.println(tmp-1);
    }
}
