import java.util.*;
import java.io.*;

public class ChangingCoin_2624 {
  private static int T; // 지폐의 금액
  private static int K; // 동전의 가지 수
  private static BufferedReader bufferedReader;
  
  private static int[][] coins;
  private static int[][] dp;
  
  public static void main(String[] args) throws IOException {
    initializeBufferedReader();
    inputTK();
    inputCoins();
    processDP();
    outputResult();
  }
  
  private static void initializeBufferedReader() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }
  
  private static void inputTK() throws IOException {
    T = Integer.parseInt(bufferedReader.readLine());
    K = Integer.parseInt(bufferedReader.readLine());
  }
  
  private static void inputCoins() throws IOException {
    coins = new int[K][2];
    for (int i=0; i<K; i++) {
      StringTokenizer rawCoin = new StringTokenizer(bufferedReader.readLine());
      coins[i][0] = Integer.parseInt(rawCoin.nextToken()); // 동전의 금액
      coins[i][1] = Integer.parseInt(rawCoin.nextToken()); // 동전의 개수
    }
    
    Arrays.sort(coins, new Comparator<int[]>() {
      @Override
      public int compare(int[] coin1, int[] coin2) {
        return coin1[0] - coin2[0]; // 동전의 금액으로 오름차순 정렬
      }
    });
  }
  
  private static void processDP() {
    dp = new int[10_000 + 1][K+1];
    
    // 한 가지 동전만 가지고 만들 수 있는 경우의 수 초기화
    for (int i=0; i<coins.length; i++) {
      for (int j=1; j<=coins[i][1]; j++) {
        int coin = coins[i][0];
        if (coin * j > 10_000) {
          break;
        }
        dp[coin * j][i+1] = 1;
      }
    }
    
    // 동전 두 가지 이상 혼합해서 만드는 경우의 수
    for (int i=1; i<dp.length; i++) {
      for (int j=2; j<dp[i].length; j++) {
        for (int k=0; k<=coins[j-1][1]; k++) {
          int quotient = coins[j-1][0] * k;
          int remainder = i - quotient;
          if (remainder < 0) {
            break;
          }
          dp[i][j] += dp[remainder][j-1];
        }
      }
    }
  }
  
  private static void outputResult() {
    System.out.println(dp[T][K]);
  }
}
