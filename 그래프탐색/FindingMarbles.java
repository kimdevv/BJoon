import java.io.*;
import java.util.*;

public class FindingMarbles {
  public static int stoi(String str) {
    return Integer.parseInt(str);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = stoi(st.nextToken()); // 구슬의 개수
    int M = stoi(st.nextToken()); // 저울에 올려본 쌍의 개수

    // 현재 구슬보다 무거운 구슬 리스트, 가벼운 구슬 리스트를 다 만듦
    boolean[][] lightList = new boolean[N+1][N+1];
    boolean[][] heavyList = new boolean[N+1][N+1];
    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int heavy = stoi(st.nextToken());
      int light = stoi(st.nextToken());
      
      lightList[heavy][light] = true;
      heavyList[light][heavy] = true;
    }
    
    for (int i=1; i<=N; i++) { // 거쳐가는 노드
      for (int j=1; j<=N; j++) { // 시작 노드
        for (int k=1; k<=N; k++) { // 끝 노드
          if (lightList[j][i] && lightList[i][k]) {
            lightList[j][k] = true;
          }
          if (heavyList[j][i] && heavyList[i][k]) {
            heavyList[j][k] = true;
          }
        }
      }
    }

    // 자신보다 무겁거나 가벼운 구슬 수가 과반이라면 중간이 될 수 없음.
    int impossibleCount = 0;
    for (int i=1; i<=N; i++) {
      int lightCount = 0;
      int heavyCount = 0;
      for (int j=1; j<=N; j++) {
        if (lightList[i][j]) {
          lightCount++;
        }
        if (heavyList[i][j]) {
          heavyCount++;
        }
      }
      
      if (lightCount > N/2 || heavyCount > N/2) {
        impossibleCount++;
      }
    }
    
    System.out.println(impossibleCount);
  }
}
