import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Budget_2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 지방의 수

        int[] budgets = new int[N];
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budgets[i]);
        }

        int totalBudget = Integer.parseInt(br.readLine()); // 전체 국가예산

        int result = 0;
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }
            if (sum > totalBudget) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}