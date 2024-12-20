import java.io.*;
import java.util.*;

public class GuitarList_1495 {
    private static int N; // 곡의 개수
    private static int S; // 시작 볼륨
    private static int M; // 볼륨 최대값

    private static int[] changeVolume;
    private static boolean[][] dp;

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputNSM();
        initializeChangeVolume();
        processDP();
        outputResult();
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
        dp = new boolean[N+1][M+1];
        dp[0][S] = true;
        for (int i=1; i<=N; i++) {
          for (int j=0; j<=M; j++) {
            if (dp[i-1][j]) {
              if (j + changeVolume[i] <= M) {
                dp[i][j + changeVolume[i]] = true;
              }
              if (j - changeVolume[i] >= 0) {
                dp[i][j - changeVolume[i]] = true;
              }
            }
          }
        }
    }
    
    private static void outputResult() {
      for (int i=M; i>=0; i--) {
        if (dp[N][i]) {
          System.out.println(i);
          return;
        }
      }
      System.out.println(-1);
    }
}
