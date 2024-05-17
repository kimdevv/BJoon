import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());
        int[][] dp = new int[n+1][n+1];

        int[][] arr = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=i; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];
        for (int i=2; i<=n; i++) {
            for (int j=1; j<i; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+arr[i][j]);
                dp[i][j+1] = dp[i-1][j] + arr[i][j+1];
            }
        }

        int max = 0;
        for (int i=1; i<=n; i++) {
            if (max < dp[n][i]) {
                max = dp[n][i];
            }
        }
        System.out.println(max);
    }
}