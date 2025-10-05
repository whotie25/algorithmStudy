//1009. 분산처리
package BaekjoonOnlineJudge.Mathematics;
import java.util.Scanner;

public class boj_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int a, b;
        int res;

        for(int i = 0; i < tc; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            a %= 10;
            if(a == 0){
                 System.out.println(10); continue;
            }
            else if(a == 1 || a == 5 || a == 6) {
                System.out.println(a); continue;
            }

            b %= 4;
            if(b == 1){
                System.out.println(a); continue;
            }
            if(a == 2){
                switch(b){
                    case 0:
                        res = 6; break;
                    case 2:
                        res = 4; break;
                    case 3:
                        res = 8; break;
                    default:
                        res = -1;
                }
                System.out.println(res); continue;
            } else if(a == 3){
                switch(b){
                    case 0:
                        res = 1; break;
                    case 2:
                        res = 9; break;
                    case 3:
                        res = 7; break;
                    default:
                        res = -1;
                }
                System.out.println(res); continue;
            } else if(a == 7){
                switch(b){
                    case 0:
                        res = 1; break;
                    case 2:
                        res = 9; break;
                    case 3:
                        res = 3; break;
                    default:
                        res = -1;
                }
                System.out.println(res); continue;
            } else if(a == 8){
                switch(b){
                    case 0:
                        res = 6; break;
                    case 2:
                        res = 4; break;
                    case 3:
                        res = 2; break;
                    default:
                        res = -1;
                }
                System.out.println(res); continue;
            }

            b %= 2;
            if(a == 4){
                if(b == 0) res = 6;
                else res = 4;
                System.out.println(res); continue;
            } else {
                if(b == 0) res = 1;
                else res = 9;
                System.out.println(res);
            }
        } 
        sc.close();
    }
}