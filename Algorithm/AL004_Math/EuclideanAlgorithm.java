package AL004_Math;
import java.util.Scanner;

public class EuclideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(">>> Input two natural numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        System.out.printf(">>> Recursive Euclidean GCD : %d\n", recursiveEuclideanGCD(a, b));
        System.out.printf(">>> While Euclidean GCD     : %d\n", whileEuclideanGCD(a, b));
    }

    public static int recursiveEuclideanGCD(int a, int b) {
        int r = a % b;

        if(r == 0) return b;

        return recursiveEuclideanGCD(b, r);
    }

    public static int whileEuclideanGCD(int a, int b) {
        int r = -1;

        while(r != 0) {
            r = a % b;

            a = b;
            b = r;
        }

        return a;
    }
}
