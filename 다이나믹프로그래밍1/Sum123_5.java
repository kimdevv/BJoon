import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Sum123_5 {
    static long[][] dp = new long[100001][4];

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1][1] = 1; // 1
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 0;
        dp[2][2] = 1; // 2
        dp[2][3] = 0;

        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        int T = stoi(br.readLine());

        for (int k=0; k<T; k++) {
            int N = stoi(br.readLine());

            for (int i=4; i<=N; i++) {
                if (dp[i][1]==0 && dp[i][2]==0 && dp[i][3]==0) {
                    dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
                    dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
                    dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
                }
            }

            long ret = (dp[N][1] + dp[N][2] + dp[N][3]) % 1000000009;
            System.out.println(ret);
        }
    }
}