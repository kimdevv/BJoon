import java.io.*;

public class KriiiBoard_11058 {
  private static int N;
  private static long[] dp;
  
  public static void main(String[] args) throws IOException {
    inputN();
    processDP();
    outputResult();
  }
  
  private static void inputN() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bufferedReader.readLine());
  }
  
  private static void processDP() {
    dp = new long[100 + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    
    long buffer = 1;
    for (int i=4; i<=N; i++) {
      if (dp[i-1]+buffer > dp[i-4]*3) {
        dp[i] = dp[i-1] + buffer;
      } else {
        dp[i] = dp[i-4] * 3;
        buffer = dp[i-4];
      }
    }
  }
  
  private static void outputResult() {
    System.out.println(dp[N]);
  }
}
