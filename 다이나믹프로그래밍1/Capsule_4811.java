import java.io.*;
import java.util.*;

public class Capsule_4811 {
  private static long[] dp;
  
  public static void main(String[] args) {
    processDP();
    inputTestCases();
  }
  
  private static void processDP() {
    dp = new long[30 + 1];
    for (int i=1; i<dp.length; i++) {
      dp[i] = (i) + dp[i-1];
    }
  }
  
  private static void inputTestCases() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int N; // 약의 개수
    do {
      N = Integer.parseInt(bufferedReader.readLine());
    } while (N != 0);
  }
}

/*
WH

WWHH
WHWH

WWWHHH
WWHWHH
WWHHWH
WHWHWH
WHWWHH


WWWWHHHH
WWWHWHHH
WWWHHWHH
WWWHHHWH
WWHWWHHH
WWHWHWHH
WWHWHHWH
WWHHWWHH
WWHHWHWH
WWHHHWWH
WHWWWHHH
WHWWHWHH
WHWWHHWH
WHWHWWHH
WHWHWHWH
*/
