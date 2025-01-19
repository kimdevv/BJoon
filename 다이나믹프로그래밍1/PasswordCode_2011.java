import java.io.*;
import java.util.*;

public class PasswordCode_2011 {
  private static String code;
  private static long[] dp;
  
  public static void main(String[] args) throws IOException {
    inputCode();
    processDP();
    outputResult();
  }
  
  private static void inputCode() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    code = bufferedReader.readLine();
  }
  
  private static void processDP() {
    dp = new long[code.length()];
    
    if (code.startsWith("0")) { // 0으로 시작하면 코드를 해독할 수 없음.
      return;
    } else if (code.length() == 1) { // 1글자 코드는 경우의 수가 무조건 1.
      dp[0] = 1;
      return;
    }
    
    dp[0] = 1;
    for (int i=1; i<dp.length; i++) {
      if (code.charAt(i) == '0') { // 현재 코드가 0이라면
        if (checkUnvalidZero(i)) { // 가능한 코드인지 검증
          dp[code.length() - 1] = 0;
          return;
        } else {
          dp[i] = dp[i-2 < 0 ? 0 : i-2];
        }
      } else { // 0이 아니라면
        if (checkTwoDigitUnder26(i)) { // 앞의 코드 문자와 함께 10~26 사이의 수인지 확인
          dp[i] = (dp[i-1] + dp[i-2 < 0 ? 0 : i-2]) % 1000000;
        } else {
          dp[i] = dp[i-1] % 1000000;
        }
      }
    }
  }
  
  private static boolean checkUnvalidZero(int index) {
    char previousChar = code.charAt(index - 1);
    if (previousChar == '1' || previousChar == '2') {
      return false;
    }
    return true;
  }
  
  private static boolean checkTwoDigitUnder26(int index) {
    char firstChar = code.charAt(index - 1);
    char secondChar = code.charAt(index);
    int number = Integer.parseInt(firstChar + "" + secondChar);
    if (10 <= number && number <= 26) {
      return true;
    }
    return false;
  }
  
  private static void outputResult() {
    System.out.println(dp[code.length() - 1] % 1000000);
  }
}
