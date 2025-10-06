//1929. 소수 구하기
package BaekjoonOnlineJudge.Mathematics;
import java.util.Scanner;

public class boj_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        sc.close();

        for(int i = min; i <= max; i++) {
            if(naiveMethod(i) == true) System.out.println(i);
        }
    }

    public static boolean naiveMethod(int _num) {
        if(_num <= 1) return false;
        else {
            if(_num <= 3) return true;
            else {
                for(int i = 2; i <= Math.sqrt((double)_num); i++) {
                    if(_num % i == 0) return false;
                }
                return true;
            }
        }
    }
}