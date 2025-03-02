import java.io.*;
import java.util.*;

public class SumOfTwoAttorney_2410 {
  private static int N;
  private static long[] dp;
  private static List<Integer> twoPower;

  public static void main(String[] args) throws IOException {
    inputN();
    initializeTwoPower();
    processDP();
    outputResult();
  }

  private static void inputN() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bufferedReader.readLine());
  }

  private static void initializeTwoPower() {
    twoPower = new ArrayList<>();
    for (int i=0; Math.pow(2, i)<=1_000_000; i++) {
      twoPower.add((int)Math.pow(2, i));
    }
  }

  private static void processDP() {
    dp = new long[N+1];
    dp[1] = 1;

    for (int i=2; i<dp.length; i++) {
      if (checkEven(i)) {
        dp[i] = (dp[i-1] + dp[i/2]) % 1_000_000_000;
        continue;
      }
      dp[i] = dp[i-1];
    }
  }

  private static boolean checkEven (int number) {
    if (number %2 == 0) {
      return true;
    }
    return false;
  }

  private static void outputResult() {
    System.out.println(dp[N] % 1_000_000_000);
  }
}
