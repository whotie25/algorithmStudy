//2563. 색종이
package BaekjoonOnlineJudge.Implementation;
import java.util.Scanner;

public class boj_2563 {
    public static void main(String[] args) {
        boolean[][] gnd = new boolean[100][100];
        int area = 0;

        Scanner sc = new Scanner(System.in);
        int rep = sc.nextInt();
        for(int i = 0; i < rep; i++) {
            int x = sc.nextInt(), y = sc.nextInt();

            for(int j = x-1; j < x+9; j++) {
                for(int k = y-1; k < y+9; k++) {
                    if(gnd[j][k] == false) {
                        gnd[j][k] = true;
                        area++;
                    }
                }
            }
        }
        sc.close();

        System.out.print(area);
    }
}