import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wine {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());

        int[] wine = new int[n+2];
        for(int i=1; i<=n; i++) {
            wine[i] = stoi(br.readLine());
        }
        
        /* 0: 직전꺼없음 1:직전꺼있음
        dp[1][0] = wine[1]; // 6
        dp[1][1] = 0;
        
        dp[2][0] = wine[2]; // 10
        dp[2][1] = dp[1][0]+dp[1][1] + wine[2]; // 16
        
        dp[3][0] = <dp[1][0], dp[1][1]>+wine[3]; // 19
        dp[3][1] = dp[2][0] + wine[3]; // 23
        
        dp[4][0] = <dp[2][0], dp[2][1]> + wine[4] // 25
        dp[4][1] = dp[3][0] + wine[4] // 28
        
        dp[5][0] = <dp[3][0], dp[3][1]> + wine[5] // 31
        dp[5][1] = dp[4][0] + wine[5] // 33
        
        dp[6][0] = <dp[4][0], dp[4][1]> + wine[6] // 29
        dp[6][1] = dp[5][0] + wine[6] // 32
        */

        int[][] dp = new int[n+2][2];
        dp[1][0] = wine[1];
        dp[2][0] = Math.max(dp[0][0], dp[0][1]) + wine[2];
        dp[2][1] = dp[1][0] + wine[2];

        for(int i=3; i<=n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-2][0], dp[i-2][1]), Math.max(dp[i-3][0], dp[i-3][1])) + wine[i];
            dp[i][1] = dp[i-1][0] + wine[i];
        }

        System.out.println(Math.max(dp[n][1], Math.max(dp[n][0], dp[n-1][1])));
    }
}