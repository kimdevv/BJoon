import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BiggestIncreasingSequence {

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
        dp[1] = arr[1];

        int max = dp[1];
        for (int i=2; i<=N; i++) {
            int tmp = arr[i];
            for (int j=i-1; j>0; j--) {
                if(arr[i] <= arr[j]) {
                    continue;
                }

                int calc = dp[j] + arr[i];
                if (tmp < calc) {
                    tmp = calc;
                }
            }
            dp[i] = tmp;
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}