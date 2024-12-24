import java.io.*;
import java.util.*;

public class TigerEatingRiceCake_2502 {
    private static int D; // 할머니가 넘어온 날
    private static int K; // 그 날 호랑이에게 준 떡의 개수
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        inputDK();
        processDP();
        outputResult();
    }

    private static void inputDK() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        D = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void processDP() {
        dp = new int[30 + 1];
        for (int i=1; i<=99999; i++) {
            dp[1] = i;
            for (int j=i+1; j<=100000; j++) {
                dp[2] = j;
                for (int k=3; k<=30; k++) {
                    dp[k] = dp[k-2] + dp[k-1];
                }
                if (dp[D] == K) {
                    return;
                }
            }
        }
    }

    private static void outputResult() {
        System.out.println(dp[1]);
        System.out.println(dp[2]);
    }
}