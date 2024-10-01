import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stair_10844 {
    static int[][] dp;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        dp = new int[N+1][10];
        for (int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=N; i++) {
            for (int j=0; j<10; j++) {
                if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % 1000000000;
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long ret = 0;
        for (int i=0; i<10; i++) {
            ret += dp[N][i];
        }
        System.out.println(ret % 1000000000);
        
        /*
        dp[2] = 8+9; // 17
        dp[3] = 7+7+8+9;//
        dp[4] = 6+6+6+7+7+8+9;*/
        
        /*
        12 23 34 45 56 67 78 89
        98 87 76 65 54 43 32 21 10
        
        123 234 345 456 567 678 789
        121 232 343 454 565 676 787 898
        101 212 323 434 545 656 767 878 989
        987 876 765 654 543 321 210
        
        x9
        1
        2
        3
        4
        5
        6
        7
        8
        9
        
        x17
        10 12
        21 23
        32 34
        43 45
        54 56
        65 67
        76 78
        87 89
        98
        
        x32 11+16+17+18
        101 121 123
        210 212 232 234
        321 323 343 345
        4 5 6
        765 767 787 789
        876 878 898
        987 989
        
        x27+24+10 = 61
        1010 1012 1210 1212 1232 1234
        2101 2121 2123 2321 2323 2343 2345
        3210 3212 3232 3234 3432 3434 3454 3456
        4321 4323 4343 4345 4543 4545 4565 4567
        5432 5434 5454 5456 5654 5656 5676 5678
        6543 6545 6565 6567 6765 6767 6787 6789
        7654 7656 7676 7678 7876 7878 7898
        8765 8767 8787 8789 8987 8989
        9876 9878 9898
        */
    }
}