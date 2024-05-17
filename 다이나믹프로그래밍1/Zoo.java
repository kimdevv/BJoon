import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Zoo {

    static int MOD = 9901;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        long[][] dp = new long[N+1][2];

        dp[1][0] = 1;
        dp[1][1] = 2;

        for (int i=2; i<=N; i++) {
            // N번째 층을 쌓지 않는 경우는 N-1번째 까지만 쌓는 경우와 동일한 경우의 수.
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
          
          /*
          N번째 층을 쌓는 경우의 수 :
            N-1번째까지 쌓아뒀다면, 거기에 의해 하나만 더 올려진다 (dp[i-1][1])
            N-1번째가 쌓이지 않았다면, 거기서 왼쪽과 오른쪽 둘을 쌓을 수 있다. (dp[i-1][0]*2)
          */
            dp[i][1] = (dp[i-1][1] + dp[i-1][0]*2) % MOD;
        }

        System.out.println((dp[N][0]+dp[N][1]) % MOD);
    }
}