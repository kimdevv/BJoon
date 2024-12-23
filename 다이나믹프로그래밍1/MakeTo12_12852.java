import java.io.*;
import java.util.*;

public class MakeTo12_12852 {
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        processDP();
        inputN();
        outputResult();
    }

    private static void inputN() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
    }

    private static void processDP() {
        dp = new int[1_000_000 + 1];
        dp[1] = 0;
        for (int i=2; i<dp.length; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(1 + dp[i-1], Math.min(1 + dp[i/3], 1 + dp[i/2]));
            } else if (i % 3 == 0) {
                dp[i] = Math.min(1 + dp[i-1], 1 + dp[i/3]);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(1 + dp[i-1], 1 + dp[i/2]);
            } else {
                dp[i] = 1 + dp[i-1];
            }
        }
    }

    private static void outputResult() {
        outputCount();
        outputProgress(N);
    }

    private static void outputCount() {
        System.out.println(dp[N]);
    }

    private static int outputProgress(int index) {
        // 사실 이 부분은 굳이 이렇게 반복문을 한 번 더 돌리지 않아도
        // 경로 배열을 하나 더 만들어서 dp작업 진행할 때
        // 자신까지의 경로를 함께 저장해오면 굳이 이렇게 안 해도 됨 
        
        if (index == 0) {
            return -1;
        }
        System.out.print(index + " ");

        if (index % 6 == 0) {
            if (dp[index/3] > dp[index/2]) {
                if (dp[index/2] > dp[index-1]) {
                    return outputProgress(index-1);
                } else {
                    return outputProgress(index / 2);
                }
            } else {
                if (dp[index/3] > dp[index-1]) {
                    return outputProgress(index-1);
                } else {
                    return outputProgress(index / 3);
                }
            }
        } else if (index % 3 == 0) {
            if (dp[index-1] > dp[index/3]) {
                return outputProgress(index / 3);
            } else {
                return outputProgress(index-1);
            }
        } else if (index % 2 == 0) {
            if (dp[index-1] > dp[index/2]) {
                return outputProgress(index / 2);
            } else {
                return outputProgress(index-1);
            }
        } else {
            return outputProgress(index-1);
        }
    }
}