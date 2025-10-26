//31628. 가지 한 두름 주세요
package BaekjoonOnlineJudge.Implementation;
import java.util.Scanner;

public class boj_31628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[][] eggPlant = new String[10][10];

        //row check
        for(int i = 0; i < 10; i++) {
            String trg = sc.next();
            eggPlant[i][0] = trg;
            boolean chk = false;
            for(int j = 1; j < 10; j++) {
                String tmp = sc.next();
                eggPlant[i][j] = tmp;
                if(!tmp.equals(trg)) chk = true; 
            }
            if(chk == false) {
                System.out.print(1); sc.close(); return;
            }
        }
        //column check
        for(int i = 0; i < 10; i++) {
            String trg = eggPlant[0][i];
            boolean chk = false;
            for(int j = 1; j < 10; j++) {
                if(!eggPlant[j][i].equals(trg)) {
                    chk = true;
                    break;
                }
            }
            if(!chk){
                System.out.print(1); sc.close(); return;
            }
        }
        //default
        System.out.print(0);
        sc.close();
    }
}