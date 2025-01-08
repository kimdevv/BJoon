import java.io.*;
import java.util.*;

public class LCS_9251 {
  private static String string1;
  private static String string2;
  private static int[][] dp;

  public static void main(String[] args) throws IOException {
    inputStrings();
    processDP();
    outputResult();
  }

  private static void inputStrings() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    string1 = bufferedReader.readLine();
    string2 = bufferedReader.readLine();
  }

  private static void processDP() {
    dp = new int[string1.length()+1][string2.length()+1];
    for (int i=1; i<dp.length; i++) {
      char alphabet = string1.charAt(i-1);
      for (int j=1; j<dp[i].length; j++) {
        if (alphabet == string2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
  }

  private static void outputResult() {
    int length1 = string1.length();
    int length2 = string2.length();
    System.out.println(dp[length1][length2]);
  }
}
