import java.io.*;
import java.util.*;

public class SugarDelivery_2839 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    
    int[] dp = new int[N + 1];
    Arrays.fill(dp, 100_000);
    
    dp[0]= 0;
    for (int i=1; i<=N; i++) {
      if (i >= 3) {
        dp[i] = Math.min(dp[i], dp[i - 3] + 1);
      }
      if (i >= 5) {
        dp[i] = Math.min(dp[i], dp[i - 5] + 1);
      }
    }
    
    System.out.println(dp[N] == 100_000 ? -1 : dp[N]);
    br.close();
  }
}
