//2108. 통계학
package BaekjoonOnlineJudge.Sort;
import java.util.Scanner;

public class boj_2108 {
    public static void main(String[] args) {
        int min = 4000, max = -4000, sum = 0;
        int[] freq = new int[8001];
        int freq_max = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();

            //mean
            sum += tmp;

            //median n' mode
            freq[tmp+4000]++;
            if(freq[tmp+4000] > freq_max) freq_max = freq[tmp+4000];

            //range
            if(tmp < min) min = tmp;
            if(tmp > max) max = tmp;
        }
        sc.close();

        float mean = sum/(float)n;
        int intMean;
        if(mean >= 0 ) intMean = (int)mean;
        else intMean = (int)mean - 1;
        if(mean - intMean >= 0.5) intMean++;
        System.out.println(intMean); //mean

        int freq_sum = 0, idx = 0;
        while(freq_sum <= n/2) {
            freq_sum += freq[idx]; idx++;
        }
        System.out.println(idx-4001); //median

        int flag = 0, rt = 0;
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] == freq_max) {
                flag++;
                rt = i - 4000;
            }

            if(flag == 2) break;
        }
        System.out.println(rt); //mode

        System.out.println(max - min); //range

    }
}
