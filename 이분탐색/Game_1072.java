import java.io.*;
import java.util.*;

public class Game_1072 {
  public static long stol(String string) {
    return Long.parseLong(string);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    double X = (double)stol(stringTokenizer.nextToken()); // 게임 횟수
    long Y = stol(stringTokenizer.nextToken()); // 이긴 게임 수
    long nowRate = (long)(Y*100 / X); // 현재 승률
    long findValue = nowRate + 1; // 찾아야 하는 값
    
    long result = -1;
    long left = 0;
    long right = 1_000_000_000;
    while (left <= right) {
      long mid = (left + right) / 2; // 추가로 플레이하는 횟수
      
      double nextGame = X + mid;
      long nextWin = Y + mid;
      long nextRate = (long)(nextWin*100 / nextGame); // mid회 게임을 더 플레이했을 때의 승률
      
      if (nextRate >= findValue) {
        result = mid;
        right = mid - 1;
      } else if (nextRate < findValue) {
        left = mid + 1;
      }
    }
    
    System.out.println(result);
  }
}
