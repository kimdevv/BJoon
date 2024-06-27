import java.util.*;
import java.io.*;

public class Retire {

    public static int stoi(String str) {
      return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = stoi(br.readLine());
      int[] T = new int[N+1];
      int[] P = new int[N+1];
      
      for (int i=1; i<N+1; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T[i] = stoi(st.nextToken());
        
        // 퇴사날을 넘기게 되는 작업은 받지 않는다 (보수 0)
        P[i] = (i+T[i] > N+1) ? 0 : stoi(st.nextToken());
      }
      
      int max = 0; // 출력할 값 (가장 큰 보수)
      
      for (int i=1; i<N+1; i++) {
        int tmp = P[i];
        for (int j=0; j<i; j++) {
          
          // 1. 이전의 작업을 수행해도 오늘의 작업을 넘기지 않는 경우
          // 2. 수행 가능한 이전 작업 중 가장 보수가 큰 작업을 선택
          if ((j + T[j] <= i) && (P[j]+tmp >= P[i])) {
            P[i] = P[j] + tmp;
            
            if (P[i] > max) {
              max = P[i];
            }
            
          }
        }
      }
      
      System.out.println(max);
  }
}
