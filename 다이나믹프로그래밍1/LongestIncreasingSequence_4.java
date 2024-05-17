import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSequence_4 {

    static int[] dp;
    static int[] A;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        A = new int[N+1]; // 수열 A

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            A[i] = stoi(st.nextToken());
        }

        dp = new int[N+1];
        dp[1] = 1;

        String[] sa = new String[N+1];
        sa[1] = Integer.toString(A[1]);

        int now = 1;
        for (int i=2; i<=N; i++) {
            dp[i] = 1;
            for (int j=1; j<i; j++) {
                if (A[i] > A[j]) {
                    if (dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                        now = j;
                    }
                }
            }
            if (dp[i] > dp[now]) {
                sa[i] = sa[now] + " " + A[i];
            } else {
                sa[i] = Integer.toString(A[i]);
            }
        }

        int max = 0;
        int max_i = 0;
        for (int i=1; i<=N; i++) {
            if (max <= dp[i]) {
                max = dp[i];
                max_i = i;
            }
        }
        System.out.println(max);
        System.out.println(sa[max_i]);
    }
}