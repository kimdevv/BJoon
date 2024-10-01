import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum2_13398 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int[][] dp = new int[N+1][2];
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];

        for (int i=2; i<=N; i++) {
            dp[i][0] = Math.max(arr[i], dp[i-1][0]+arr[i]);
            dp[i][1] = Math.max(dp[i-1][1] + arr[i], dp[i-1][0]);
        }

        int max = Integer.MIN_VALUE;
        for (int i=1; i<=N; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
            if (dp[i][1] > max) {
                max = dp[i][1];
            }
        }
        System.out.println(max);
    }
}