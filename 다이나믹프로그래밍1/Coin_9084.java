import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin_9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 동전의 가지 수
            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(coins);

            int M = Integer.parseInt(br.readLine()); // 목표 금액

            int[] dp = new int[M + 1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                int coin = coins[i];
                for (int j = coin; j <= M; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            System.out.println(dp[M]);
        }
        br.close();
    }
}
