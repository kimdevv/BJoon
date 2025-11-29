import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class FindingPath_11403 {
  
  private static int N;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine()); // 정점의 개수
    
    int[][] costs = new int[N][N];
    for (int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j=0; j<N; j++) {
        costs[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for (int k=0; k<N; k++) {
      for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
          if (costs[i][k] == 1 && costs[k][j] == 1) {
            costs[i][j] = 1;
          }
        }
      }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        sb.append(costs[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
    
    br.close();
  }
}
