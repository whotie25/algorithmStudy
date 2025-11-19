//2749. 피보나치 수 3
package BaekjoonOnlineJudge.Mathematics;
import java.util.Scanner;

public class boj_2749 {
    public static void main(String[] args) {
        // INPUT
        Scanner sc = new Scanner(System.in);
        long nth = sc.nextLong() - 1;
        sc.close();

        // INPUT PROCESSING
        if(nth == 0) {
            System.out.println(1);
            return;
        }

        long divnum = 0x4000_0000_0000_0000L;
        String binnth = "";

        while(true) {
            if(nth/divnum == 0) divnum /= 2;
            else break;
        }
        while(divnum != 0) {
            if(nth/divnum == 1) {
                binnth += "1";
                nth -= divnum;
            } else {
                binnth += "0";
            }
            divnum /= 2;
        }

        int size = binnth.length();

        // FIBONACCI (MATRIX)
        long[][] power = new long[size][3];
        power[0][0] = 1; power[0][1] = 1; power[0][2] = 0;

        for(int i = 1; i < size; i++) {
            power[i][0] = (power[i-1][0]*power[i-1][0] + power[i-1][1]*power[i-1][1])%1000000;
            power[i][1] = (power[i-1][0]*power[i-1][1] + power[i-1][1]*power[i-1][2])%1000000;
            power[i][2] = (power[i-1][1]*power[i-1][1] + power[i-1][2]*power[i-1][2])%1000000;
        }

        long[] res = power[size-1];
        //System.out.println("R = (" + res[0] + "," + res[1] + "," + res[2] + ")");
        for(int i = 0; i < size-1; i++) {
            if(binnth.charAt(size - i - 1) == '1') {
                //System.out.println("(" + res[0] + "," + res[1] + "," + res[2] + ") * (" + power[i][0] + "," + power[i][1] + "," + power[i][2] + ")");

                long[] tmp = new long[3];
                tmp[0] = (res[0]*power[i][0] + res[1]*power[i][1])%1000000;
                tmp[1] = (res[0]*power[i][1] + res[1]*power[i][2])%1000000;
                tmp[2] = (res[1]*power[i][1] + res[2]*power[i][2])%1000000;

                res = tmp;
                
                //System.out.println("R = (" + res[0] + "," + res[1] + "," + res[2] + ")");
            }
        }

        // OUTPUT
        //System.out.println(binnth + " " + size);
        System.out.println(res[0]);
    }
}
