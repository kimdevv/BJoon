import java.io.*;
import java.util.*;

public class PaperAndScissor_20444 {
  public static long stol(String string) {
    return Long.parseLong(string);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    long n = stol(stringTokenizer.nextToken()); // 가위질 횟수
    long k = stol(stringTokenizer.nextToken()); // 목표 색종이 개수
    
    boolean check = false;
    long left = 0;
    long right = n/2;
    while (left <= right) {
      long column = (left + right) / 2; // 중간값으로 column값을 정한 후
      long row = n - column; // row도 구해준다
      long result = (column+1) * (row+1); // 생기는 색종이 개수
      
      if (result > k) { // result를 더 작게 만들어 줘야 함 -> right를 내림
        right = column - 1;
      } else if (result < k) { // result를 더 크게 만들어 줘야 함 -> left를 올림
        left = column + 1;
      } else {
        check = true;
        break;
      }
    }
    System.out.println(check ? "YES" : "NO");
  }
}
