import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSquares {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] dp = new int[N+1];
        int[] digit = new int [N+1];

        dp[1] = 1;
        digit[1] = 1;

        int now = 1;
        for (int i=2; i<=N; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt == (int)sqrt) {
                digit[i] = 1;
                now = i;
                continue;
            }

            digit[i] = digit[i-1] + 1;
            for (int j=2; j<=Math.sqrt(now); j++) {
                int tmp = digit[i-(j*j)] + 1;
                if (digit[i] > tmp) {
                    digit[i] = tmp;
                }
            }
        }
        System.out.println(digit[N]);
        
        /*
        1 // 1
        2 // 1+1
        3 // 1+1+1
        4 // 4
        5 // 4 + 1
        6 // 4 + 1 + 1
        7 // 4 + 1 + 1 + 1
        8 // 4 + 4
        9 // 9
        10 // 9 + 1
        11 // 9 + 1 + 1
        12 // 9 + 1 + 1 + 1 // 4 + 4 + 4
        13 // 9 + 4
        14 // 9 + 4 + 1
        15 // 9 + 4 + 1 + 1
        16 // 16
        */

    }
}