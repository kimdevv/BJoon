import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PinaryNumber {
    static long[][] dp;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        dp = new long[N+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        long ret = dp[N][0] + dp[N][1];

        System.out.println(ret);
    }
}