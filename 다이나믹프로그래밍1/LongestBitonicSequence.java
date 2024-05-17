import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestBitonicSequence {

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

        int[][] dp = new int[N+1][2];
        dp[1][0] = 1;

        //증가하는 수열을 먼저 찾는다 [i][0]
        for (int i=2; i<=N; i++) {
            dp[i][0] = 1;

            for(int j=1; j<i; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = dp[j][0] + 1;
                    if (tmp > dp[i][0]) {
                        dp[i][0] = tmp;
                    }
                }
            }
        }

        dp[N][1] = 1;
        // 감소하는 수열을 찾는다 [i][1]
        for (int i=N-1; i>=1; i--) {
            dp[i][1] = 1;
            for(int j=N; j>i; j--) {
                if (arr[j] < arr[i]) {
                    int tmp = dp[j][1] + 1;
                    if (tmp > dp[i][1]) {
                        dp[i][1] = tmp;
                    }
                }
            }
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            int tmp = dp[i][0] + dp[i][1] - 1;
            if (max < tmp) {
                max = tmp;
            }
            //System.out.print(tmp + " ");
        }

        //System.out.println();
        System.out.println(max);
    }
}