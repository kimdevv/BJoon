import java.io.*;
import java.util.*;

public class Hello_1535 {
  private static final int HP = 100;
  private static int N; // 사람의 수
  private static int[] lose; // 인사 시 잃는 체력 배열
  private static int[] get; // 인사 시 얻는 행복 배열
  private static int[][] dp;
  private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  
  public static void main(String[] args) throws IOException {
    inputN(); // 사람의 수 N을 입력받는다.
    inputLoseGet(); // N 만큼 잃는 체력, 얻는 행복을 입력받는다.
    processDP(); // DP 작업 진행
    System.out.println(dp[N][HP-1]);
  }
  
  private static void inputN() throws IOException {
    N = Integer.parseInt(bufferedReader.readLine());
    lose = new int[N+1];
    get = new int[N+1];
    dp = new int[N+1][HP]; // HP 0~99
  }
  
  private static void inputLoseGet() throws IOException {
    StringTokenizer loseTokenizer = new StringTokenizer(bufferedReader.readLine());
    StringTokenizer getTokenizer = new StringTokenizer(bufferedReader.readLine());
    
    for (int i=1; i<=N; i++) {
      lose[i] = Integer.parseInt(loseTokenizer.nextToken());
      get[i] = Integer.parseInt(getTokenizer.nextToken());
    }
  }
  
  private static void processDP() {
    for (int i=1; i<=N; i++) {
      for (int j=1; j<100; j++) {
        if (lose[i] <= j) {
          dp[i][j] = Math.max(dp[i-1][j-lose[i]]+get[i], dp[i-1][j]);
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }
  }
}
