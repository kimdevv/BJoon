import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumDecomposition_2225 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        for (int i=1; i<=K; i++) {
            dp[1][i] = i;
        }
        for (int i=1; i<=N; i++) {
            dp[i][1] = 1;
        }

        for (int i=2; i<=N; i++) {
            for (int j=2; j<=K; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);

        /*
        N=1
          K=1: 1
          K=2: 01 10
          K=3: 001 010 100
        N=2
          K=1: 2 // dp[2][1]
          K=2: 02 20 11 // dp[2][1] + dp[1][2]
          K=3: 002 020 200 110 101 011 // dp[2][2]+dp[1][3]
        N=3
          K=1: 3 // dp[3][1]
          K=2: 03 30 12 21 // dp[3][1] + dp[2][2]
          K=3: 003 030 300 012 102 120 021 201 210 111 // dp[3][2] + dp[2][3]

        N=6
          K=1: 6
          K=2: 06 60 15 51 24 42 33
          K=3: 006 060 600 150 105 015 510 501 051 240 204 024 420 402 042 330 303 033
        */
    }
}