import java.io.*;
import java.util.*;

public class Coin1_2293 {
  private static int N; // 동전의 개수
  private static int K; // 목표 금액
  private static BufferedReader bufferedReader;
  
  private static int[] coins;
  private static int[][] dp;
  
  public static void main(String[] args) throws IOException {
    initializeBufferedReader();
    inputNK();
    inputCoins();
    processDP();
    outputResult();
  }
  
  private static void initializeBufferedReader() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }
  
  private static void inputNK() throws IOException {
    StringTokenizer NK = new StringTokenizer(bufferedReader.readLine());
    N = Integer.parseInt(NK.nextToken());
    K = Integer.parseInt(NK.nextToken());
  }
  
  private static void inputCoins() throws IOException {
    coins = new int[N];
    for (int i=0; i<N; i++) {
      int coin = Integer.parseInt(bufferedReader.readLine());
      coins[i] = coin;
    }
  }
  
  private static void processDP() {
    dp = new int[N + 1][K + 1];
    for (int i=1; i<dp.length; i++) {
      int coin = coins[i-1];
      for (int j=1; j<dp[i].length; j++) {
        if (j % coin == 0) {
          int plus = dp[i][j-coin] == 0 ? 1 : dp[i][j-coin];
          dp[i][j] = dp[i-1][j] + plus;
        } else {
          int index = j - coin < 0 ? 0 : j - coin;
          dp[i][j] = dp[i-1][j] + dp[i][index];
        }
      }
    }
  }
  
  private static void outputResult() {
    System.out.println(dp[N][K]);
  }
}
