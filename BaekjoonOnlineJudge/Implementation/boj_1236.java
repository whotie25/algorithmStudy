//1236. 성 지키기
package BaekjoonOnlineJudge.Implementation;
import java.util.Scanner;

public class boj_1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        boolean[] rowChk = new boolean[row];
        boolean[] colChk = new boolean[col];

        for(int i = 0; i < row; i++) {
            String tmp = sc.next();
            for(int j = 0; j < col; j++) {
                if(tmp.charAt(j) == 'X') {
                    rowChk[i] = true;
                    colChk[j] = true;
                }
            }
        }

        sc.close();

        int rowCnt = 0, colCnt = 0;
        for(int i = 0; i < row; i++) {
            if(rowChk[i] == false) rowCnt++;
        }
        for(int j = 0; j < col; j++) {
            if(colChk[j] == false) colCnt++;
        }

        System.out.print(rowCnt>colCnt?rowCnt:colCnt);
    }
}