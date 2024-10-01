import java.io.*;
import java.util.*;

public class Lining_2273 {
  public static class Compare {
    int other;
    
    Compare(int other) {
      this.other = other;
    }
  }
  
  public static int stoi(String str) {
    return Integer.parseInt(str);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = stoi(st.nextToken()); // 학생 수
    int M = stoi(st.nextToken()); // 키를 비교한 횟수
    
    boolean[][] frontCount = new boolean[N+1][N+1]; // 자신보다 앞에 서는 노드
    boolean[][] backCount = new boolean[N+1][N+1]; // 자신보다 뒤에 서는 노드
    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int front = stoi(st.nextToken()); // 더 앞에 서는 노드
      int back = stoi(st.nextToken()); // 더 뒤에 서는 노드
      
      frontCount[back][front] = true;
      backCount[front][back] = true;
    }
    
    for (int i=1; i<=N; i++) { // 거쳐가는 노드
      for (int j=1; j<=N; j++) { // 시작 노드
        for (int k=1; k<=N; k++) { // 끝 노드
          // 거쳐서 비교할 수 있다면 true로
          if (frontCount[j][i] && frontCount[i][k]) {
            frontCount[j][k] = true;
          }
          if (backCount[j][i] && backCount[i][k]) {
            backCount[j][k] = true;
          }
        }
      }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i=1; i<=N; i++) {
      int front = 0;
      int back = 0;
      for (int j=1; j<=N; j++) {
        // 자신보다 앞, 뒤에 몇 명이 있는지 확인
        if (frontCount[i][j]) {
          front++;
        }
        if (backCount[i][j]) {
          back++;
        }
      }
      
      // 불가능한 순서인지 확인하고 출력
      int frontRank = 1 + front;
      int backRank = N - back;
      if (frontRank > backRank) {
        sb = new StringBuilder("-1");
        break;
      } else {
        sb.append(frontRank + " " + backRank + "\n");
      }
    }
    System.out.println(sb);
  }
}
