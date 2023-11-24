import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum123 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int T = stoi(br.readLine()); // 테스트의 개수

        for (int i=0; i<T; i++) {
            int n = stoi(br.readLine());

            for (int j=4; j<=n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3]; // 각각 +1, +2, +3 해서 만드는 경우
            }

            System.out.println(dp[n]);
        }
    }
}
