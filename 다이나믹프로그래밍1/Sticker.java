import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());
        for (int k=0; k<T; k++) {

            int n = stoi(br.readLine());
            int[][] price = new int[2][n];

            for (int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<n; j++) {
                    price[i][j] = stoi(st.nextToken());
                }
            }

            int[][] dp = new int[n+1][2];
            dp[1][0] = price[0][0];
            dp[1][1] = price[1][0];

            for (int i=2; i<=n; i++) {
                dp[i][0] = Math.max(dp[i-1][1] + price[0][i-1], Math.max(dp[i-2][0], dp[i-2][1])+price[0][i-1]);
                dp[i][1] = Math.max(dp[i-1][0] + price[1][i-1], Math.max(dp[i-2][0], dp[i-2][1])+price[1][i-1]);
            }
            System.out.println(Math.max(dp[n][0], dp[n][1]));
        }
    }
}
