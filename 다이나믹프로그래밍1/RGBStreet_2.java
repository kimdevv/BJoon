import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBStreet_2 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[][] dp = new int[N+2][4];
        int[] r_cost = new int[N+2];
        int[] g_cost = new int[N+2];
        int[] b_cost = new int[N+2];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r_cost[i] = stoi(st.nextToken());
            g_cost[i] = stoi(st.nextToken());
            b_cost[i] = stoi(st.nextToken());
        }

        dp[1][1] = r_cost[1];
        dp[1][2] = g_cost[1];
        dp[1][3] = b_cost[1];

        // 처음에 R, G, B를 고르는 세 가지 경우의 수로 나눠서 생각한다.
        // 선택할 집 말고 다른 집의 Cost를 무한히 높여, 첫 선택을 내가 원하는 걸 선택할 수 밖에 없게 함.

        // 1. 처음에 빨간 집을 고른 경우
        dp[1][2] = 1000*1000+1;
        dp[1][3] = 1000*1000+1;
        for (int i=2; i<=N; i++) {
            dp[i][1] = Math.min(dp[i-1][2]+r_cost[i], dp[i-1][3]+r_cost[i]);
            dp[i][2] = Math.min(dp[i-1][1]+g_cost[i], dp[i-1][3]+g_cost[i]);
            dp[i][3] = Math.min(dp[i-1][1]+b_cost[i], dp[i-1][2]+b_cost[i]);
        }
        dp[1][2] = g_cost[1];
        dp[1][3] = b_cost[1];
        dp[0][1] = Math.min(dp[N][2], dp[N][3]); // 빨간색 최종

        // 2. 처음에 초록 집을 고른 경우
        dp[1][1] = 1000*1000+1;
        dp[1][3] = 1000*1000+1;
        for (int i=2; i<=N; i++) {
            dp[i][1] = Math.min(dp[i-1][2]+r_cost[i], dp[i-1][3]+r_cost[i]);
            dp[i][2] = Math.min(dp[i-1][1]+g_cost[i], dp[i-1][3]+g_cost[i]);
            dp[i][3] = Math.min(dp[i-1][1]+b_cost[i], dp[i-1][2]+b_cost[i]);
        }
        dp[1][1] = r_cost[1];
        dp[1][3] = b_cost[1];
        dp[0][2] = Math.min(dp[N][1], dp[N][3]); // 초록색 최종

        // 3. 처음에 파란 집을 고른 경우
        dp[1][1] = 1000*1000+1;
        dp[1][2] = 1000*1000+1;
        for (int i=2; i<=N; i++) {
            dp[i][1] = Math.min(dp[i-1][2]+r_cost[i], dp[i-1][3]+r_cost[i]);
            dp[i][2] = Math.min(dp[i-1][1]+g_cost[i], dp[i-1][3]+g_cost[i]);
            dp[i][3] = Math.min(dp[i-1][1]+b_cost[i], dp[i-1][2]+b_cost[i]);
        }
        dp[1][1] = r_cost[1];
        dp[1][2] = g_cost[1];
        dp[0][3] = Math.min(dp[N][1], dp[N][2]); // 파란색 최종


        System.out.println(Math.min(dp[0][1], Math.min(dp[0][2], dp[0][3])));
    }
}