import java.io.*;
import java.util.*;

public class Coin1_2293 {
    private static int n; // 동전 종류의 개수
    private static int k; // 동전의 합

    private static int[] coins; // 동전의 종류 배열
    private static int[] dp;

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        initializeBufferedReader();
        inputCoins();
        processDP();
        outputResult();
    }

    private static void initializeBufferedReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void inputCoins() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        coins = new int[n];
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(coins);
    }

    private static void processDP() {
        dp = new int[10_000 + 1];

        for (int coin : coins) {
            dp[coin] = 1;
        }

        int minimum = coins[0];
        for (int i=minimum; i<dp.length; i++) {
            for (int coin : coins) {
                if (i-coin > 0 && dp[i-coin] > 0 && dp[i] != 1) {
                    dp[i] += dp[i-coin];
                }
            }
        }
    }

    private static void outputResult() {
        System.out.println(dp[k]);
        System.out.println(Arrays.toString(dp));
    }
}