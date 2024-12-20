import java.io.*;
import java.util.*;

public class Undecreasable_2688 {
  private static long[][] dp;
  
  public static void main(String[] args) throws IOException {
    processDP();
    outputResult();
  }
  
  private static void processDP() {
    dp = new long[64+1][10];
    Arrays.fill(dp[1], 1);
    
    for (int i=2; i<dp.length; i++) {
      long prevSum = Arrays.stream(dp[i-1]).sum();
      for (int j=0; j<=9; j++) {
        dp[i][j] = prevSum;
        prevSum -= dp[i-1][j];
      }
    }
  }
  
  private static void outputResult() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bufferedReader.readLine());
    for (int i=0; i<T; i++) {
      int digit = Integer.parseInt(bufferedReader.readLine());
      System.out.println(Arrays.stream(dp[digit]).sum());
    }
  }
}
