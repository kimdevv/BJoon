import java.io.*;
import java.util.*;

public class Stock_11501 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine()); // 날의 수
      
      int[] stocks = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i=0; i<N; i++) {
        stocks[i] = Integer.parseInt(st.nextToken());
      }
      
      int max = Integer.MIN_VALUE;
      long revenue = 0;
      for (int day=N-1; day>=0; day--) {
        if (stocks[day] > max) {
          max = stocks[day];
        } else if (stocks[day] < max) {
          revenue += (max - stocks[day]);
        }
      }
      
      System.out.println(revenue);
    }
    br.close();
  }
}
