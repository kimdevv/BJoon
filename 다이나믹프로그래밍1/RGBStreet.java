import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBStreet {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[][] dp = new int[N+1][4];
        int[] r_cost = new int[N+1];
        int[] g_cost = new int[N+1];
        int[] b_cost = new int[N+1];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r_cost[i] = stoi(st.nextToken());
            g_cost[i] = stoi(st.nextToken());
            b_cost[i] = stoi(st.nextToken());
        }

        dp[1][1] = r_cost[1];
        dp[1][2] = g_cost[1];
        dp[1][3] = b_cost[1];
        for (int i=2; i<=N; i++) {
            dp[i][1] = Math.min(dp[i-1][2]+r_cost[i], dp[i-1][3]+r_cost[i]);
            dp[i][2] = Math.min(dp[i-1][1]+g_cost[i], dp[i-1][3]+g_cost[i]);
            dp[i][3] = Math.min(dp[i-1][1]+b_cost[i], dp[i-1][2]+b_cost[i]);
        }

        System.out.println(Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3])));
    }
}
