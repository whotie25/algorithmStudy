package DataStructureStudy.ListStackQueue;
import java.util.Scanner;
import java.util.ArrayList;

public class DS_001_ArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int getNum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(true) {
            System.out.print("Enter a positive integer : ");
            getNum = sc.nextInt();
            if(getNum != -1) list.add(getNum);
            else break;
        }
        sc.close();

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
