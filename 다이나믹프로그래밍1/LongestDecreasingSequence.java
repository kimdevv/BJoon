import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestDecreasingSequence {

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

        int[] dp = new int[N+1];
        dp[1] = 1;

        for (int i=2; i<=N; i++) {
            dp[i] = 1;
            for(int j=1; j<i; j++) {
                if (arr[j] > arr[i]) {
                    int tmp = dp[j] + 1;
                    if (tmp > dp[i]) {
                        dp[i] = tmp;
                    }
                }
            }
        }

        int max = dp[1];
        for (int i=2; i<=N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}