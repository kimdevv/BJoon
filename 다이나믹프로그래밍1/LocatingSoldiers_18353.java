import java.io.*;
import java.util.*;

public class LocatingSoldiers_18353 {
  private static int N;
  private static int[] soldiers;
  private static int[] dp;
  
  public static void main(String[] args) throws IOException {
    inputSoldiers();
    processDP();
    outputResult();
  }
  
  private static void inputSoldiers() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bufferedReader.readLine());
    
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    soldiers = new int[N];
    for (int i=0; i<N; i++) {
      soldiers[i] = Integer.parseInt(stringTokenizer.nextToken());
    }
  }
  
  private static void processDP() {
    dp = new int[N];
    dp[0] = 1;
    for (int i=1; i<soldiers.length; i++) {
      dp[i] = findMax(i) + 1;
    }
  }
  
  private static int findMax(int index) {
    int max = 0;
    for (int i=index-1; i>=0; i--) {
      if (soldiers[index] < soldiers[i]) {
        max = Math.max(max, dp[i]);
      }
    }
    return max;
  }
  
  private static void outputResult() {
    int max = Arrays.stream(dp).max().getAsInt();
    System.out.println(N - max);
  }
}
