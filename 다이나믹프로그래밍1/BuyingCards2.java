import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyingCards2 {

    static int[] dp;
    static int[] price;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        dp = new int[N+1]; // 금액의 최댓값을 저장하는 dp 배열
        price = new int[N+1]; // 가격 Pi를 저장하는 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++) {
            price[i] = stoi(st.nextToken());
        }

        dp[1] = price[1];
        for (int i=2; i<=N; i++) {
            int min = price[i]; // N개를 한 번에 살 수 있는 가격과 비교
            for (int j=1; j<i; j++) { // 바텀탑 방식
                int tmp = dp[j] + dp[i-j];
                if (tmp < min) { min = tmp; }
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}