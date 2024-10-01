import java.io.*;
import java.util.*;

public class Excercise_1956 {
  
  public static class Route {
    int end;
    int distance;
    
    Route(int end, int distance) {
      this.end = end;
      this.distance = distance;
    }
  }
  
  public static int stoi(String str) { return Integer.parseInt(str); }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = stoi(st.nextToken()); // 마을의 개수
    int E = stoi(st.nextToken()); // 도로의 개수
    
    int[][] distanceList = new int[V+1][V+1];
    for (int i=0; i<distanceList.length; i++) {
      Arrays.fill(distanceList[i], 10_000_000);
    }
    
    for (int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = stoi(st.nextToken());
      int end = stoi(st.nextToken());
      int distance = stoi(st.nextToken());
      
      distanceList[start][end] = distance;
    }
    
    // 반환할 최소 값
    int min = 10_000_000;
    
    // 거쳐가는 노드 계산
    for (int i=1; i<=V; i++) { // 거쳐가는 도시
      for (int j=1; j<=V; j++) { // 시작 도시
        for (int k=1; k<=V; k++) { // 끝 도시 (여러 번 거쳐가는 경우를 대비해서 모든 끝 도시를 경유해 둠)
          if (distanceList[j][k] > distanceList[j][i]+distanceList[i][k]) {
            distanceList[j][k] = distanceList[j][i]+distanceList[i][k];
          }
        }
        
        // (자기 자신으로 돌아오는 최소 경로를 탐색)
        if (distanceList[j][j] >= distanceList[j][i]+distanceList[i][j]) {
          distanceList[j][j] = distanceList[j][i]+distanceList[i][j];

          if (min > distanceList[j][j]) {
            min = distanceList[j][j];
          }
        }
      }
    }
    System.out.println(min>=10_000_000 ? -1 : min);
  }
}
