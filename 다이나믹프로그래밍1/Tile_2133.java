import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile_2133 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());
        long[] dp = new long[31];

        dp[0] = 1;
        dp[1] = 0;

        for (int i=2; i<=n; i+=2) {
            dp[i] = dp[i-2] * 3;
            for (int j=4; j<=i; j+=2) {
                dp[i] = dp[i] + 2*dp[i-j];
            }
        }
        System.out.println(dp[n]);

    }
}