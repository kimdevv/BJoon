import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum123_3 {

    static int MOD = 1000000009;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[1000001];
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 2+1, 2+1, 3

        for (int i=4; i<=1000000; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
        }

        int T = stoi(br.readLine());
        for (int i=0; i<T; i++) {
            int n = stoi(br.readLine());
            System.out.println(dp[n]);
        }

    }
}
