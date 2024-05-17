import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UprisingNumber {

    static int MOD = 10007;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    /*
    00 01 02 03 04 05 06 07 08 09
    11 12 13 14 15 16 17 18 19
    22 23 24 25 26 27 28 29
    33 34 35 36 37 38 39
    44 45 46 47 48 49
    55 56 57 58 59
    66 67 68 69
    77 78 79
    88 89
    99
    */
    
    /*
    dp[1] = 10; // 10
    dp[2] = 55; // 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 // 10 + 45 // 0 + 55
    dp[3] = 220; // 55 + 45 + 36 + 28 + 21 + 15 + 10 + 6 + 3 + 1 // 55 + 165 // 10 + 210
    dp[4] = 715; // 220 + 165 + 120 + 84 + 56 + 35 + 20 + 10 + 4 + 1 // 220 + 495 // 55 + 660
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        long[][] dp = new long[N+1][10];

        for (int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }

        long sum = 10;
        for (int i=2; i<=N; i++) {
            dp[i][9] = sum;

            for(int j=8; j>=0; j--) {
                dp[i][j] = (dp[i][j+1] - dp[i-1][j+1]);
                sum += dp[i][j]%MOD;
            }
        }

        long res = sum % MOD;
        System.out.println(res < 0 ? res+MOD : res);
    }
}