//1018. 체스판 다시 칠하기
package BaekjoonOnlineJudge.Implementation;
import java.util.Scanner;

public class boj_1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        String[] chess = new String[x];
        for(int i = 0; i < x; i++) {
            chess[i] = sc.next();
        }
        sc.close();

        x -= 7; y -= 7;

        int min = 33;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                int tmp = recolor(chess, i, j);
                if(tmp < min) min = tmp;
            }
        }

        System.out.println(min);
    }

    static int recolor(String[] board, int _x, int _y) {
        int total = 0; char base = board[_x].charAt(_y);

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if((i+j)%2 == 0 && board[i + _x].charAt(j + _y) != base) total++;
                else if((i+j)%2 != 0 && board[i + _x].charAt(j + _y) == base) total++;
            }
        }

        return (total > 32)?(64-total):total;
    }
}
