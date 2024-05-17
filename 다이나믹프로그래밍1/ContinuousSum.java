import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());

        int[] num = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            num[i] = stoi(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = num[1];
        int max = dp[1];
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i - 1] + num[i];
            if(dp[i] < num[i]) {
                dp[i] = num[i];
            }

            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}