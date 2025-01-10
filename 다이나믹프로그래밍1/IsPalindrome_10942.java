import java.io.*;
import java.util.*;

public class IsPalindrome_10942 {
  private static int N;
  private static int[] numbers;
  private static boolean[][] dp;
  private static BufferedReader bufferedReader;
  
  public static void main(String[] args) throws IOException {
    initializeBufferedReader();
    inputNumbers();
    processDP();
    outputResultAccordingToM();
  }
  
  private static void initializeBufferedReader() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }
  
  private static void inputNumbers() throws IOException {
    N = Integer.parseInt(bufferedReader.readLine());
    
    numbers = new int[N];
    StringTokenizer rawNumbers = new StringTokenizer(bufferedReader.readLine());
    for (int i=0; i<N; i++) {
      numbers[i] = Integer.parseInt(rawNumbers.nextToken());
    }
  }
  
  private static void processDP() {
    dp = new boolean[N+1][N+1];
    for (int i=0; i<dp.length; i++) { // 시작 인덱스부터 마지막 인덱스 까지의 간격
      for(int j=1; j+i<dp.length; j++) { // 시작 인덱스
        if (numbers[j-1] == numbers[j+i-1]) { // 시작 단어와 마지막 단어가 같으면
          if (j+i-1 > j+1) { // 그 안의 배열이 팰린드롬이라면 팰린드롬이 됨.
            if (dp[j+1][j+i-1]) { // 내부 배열이 팰린드롬인 경우
              dp[j][j+i] = true; 
            }
          } else { // 배열이 1~3글자라면
            dp[j][j+i] = true; // 안의 배열을 확인할 필요 없이 시작 단어와 끝 단어가 같으면 팰린드롬
          }
        }
      }
    }
  }
  
  private static void outputResultAccordingToM() throws IOException {
    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(bufferedReader.readLine());
    for (int i=0; i<M; i++) {
      StringTokenizer startAndEnd = new StringTokenizer(bufferedReader.readLine());
      int start = Integer.parseInt(startAndEnd.nextToken());
      int end = Integer.parseInt(startAndEnd.nextToken());
      if (dp[start][end]) {
        sb.append(1 + "\n");
      } else {
        sb.append(0 + "\n");
      }
    }
    System.out.println(sb);
  }
}
