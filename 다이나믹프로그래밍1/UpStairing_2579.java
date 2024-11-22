import java.io.*;
import java.util.*;

public class UpStairing_2579 { // 아직 미완성...
    static int stairCount;
    static int[] stairPoint;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        stairCount = Integer.parseInt(bufferedReader.readLine());
        stairPoint = new int[stairCount+1];
        for (int i=1; i<=stairCount; i++) {
            stairPoint[i] = Integer.parseInt(bufferedReader.readLine());
        }

        dp = new int[stairCount+1];
        dp[stairCount] = stairPoint[stairCount];
        dp[stairCount-1] = stairPoint[stairCount-1];
        int nowCount = 2;
        for (int i=stairCount-2; i>0; i--) {
            if (nowCount == 2) {
                dp[i] = stairPoint[i] + dp[i+2];
                nowCount = 1;
                if (stairPoint[i] + dp[i+1] + dp[i+3] > dp[i]) {
                    dp[i] = stairPoint[i] + dp[i+1] + dp[i+3];
                    nowCount = 2;
                }
            } else {
                if (dp[i+1] > dp[i+2]) {
                    dp[i] = stairPoint[i] + dp[i+1];
                    nowCount++;
                } else {
                    dp[i] = stairPoint[i] + dp[i+2];
                    nowCount = 1;
                }
            }
        }

        System.out.println(dp[1]);
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(stairPoint));
    }
}