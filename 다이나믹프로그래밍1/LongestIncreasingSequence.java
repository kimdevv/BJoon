import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSequence {

    static int[] dp;
    static int[] A;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        A = new int[N+1]; // 수열 A

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            A[i] = stoi(st.nextToken());
        }

        dp = new int[N+1];
        dp[1] = 1;

        int min = A[1];
        for (int i=2; i<=N; i++) {
            dp[i] = 1;
            for (int j=1; j<i; j++) {
                if (A[i] > A[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j]+1;
                }
            }
        }

        int ret = 0;
        for (int i : dp) {
            ret = Math.max(ret, i);
        }

        System.out.println(ret);
    }
}