import java.io.*;
import java.util.*;

public class GuitarList_1495 {
    private static int N; // 곡의 개수
    private static int S; // 시작 볼륨
    private static int M; // 볼륨 최대값

    private static int[] changeVolume;
    private static int[] dp;

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputNSM();
        initializeChangeVolume();
        processDP();
        System.out.println(dp[N]);
        System.out.println(Arrays.toString(dp));
    }

    private static void inputNSM() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void initializeChangeVolume() throws IOException {
        changeVolume = new int[N+1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=1; i<=N; i++) {
            changeVolume[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void processDP() {
        dp = new int[N+1];
        dp[0] = S;
        dp[1] = dp[0] + changeVolume[1];
        validateDP(1);
        dp[2] = Math.max(dp[1]+changeVolume[2], dp[0]-changeVolume[1]+changeVolume[2]);
        validateDP(2);

        for (int i=3; i<=N; i++) {
            if (dp[i-3]-changeVolume[i-2]+changeVolume[i-1]+changeVolume[i] > dp[i-1]+changeVolume[i] && dp[i-3]-changeVolume[i-2] > 0) {
                if (checkOverMax(dp[i-3]-changeVolume[i-2]+changeVolume[i-1]+changeVolume[i])) {
                    if (checkOverMax(dp[i-1]+changeVolume[i])) {
                        dp[i] = dp[i-1] - changeVolume[i];
                    } else {
                        dp[i] = dp[i-1] + changeVolume[i];
                    }
                } else {
                    dp[i] = dp[i-3]-changeVolume[i-2]+changeVolume[i-1]+changeVolume[i];
                }
            } else {
                if (checkOverMax(dp[i-1]+changeVolume[i])) {
                    if (checkOverMax(dp[i-3]-changeVolume[i-2]+changeVolume[i-1]+changeVolume[i])) {
                        dp[i] = dp[i-1] - changeVolume[i];
                    } else {
                        dp[i] = dp[i-3]-changeVolume[i-2]+changeVolume[i-1]+changeVolume[i];
                    }
                } else {
                    dp[i] = dp[i-1] + changeVolume[i];
                }
            }
        }
    }

    private static boolean checkOverMax(int number) {
        if (number > M) {
            return true;
        }
        return false;
    }

    private static void validateDP(int index) {
        if (dp[index] > M) {
            dp[index] = dp[index-1] - changeVolume[index];
        }
    }
}