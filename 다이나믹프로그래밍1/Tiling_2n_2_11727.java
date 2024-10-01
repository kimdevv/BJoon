import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling_2n_2_11727 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = stoi(br.readLine());

        long[] dp = new long[X+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=X; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]*2) % 10007;
        }

        System.out.println(dp[X]);
    }
}
