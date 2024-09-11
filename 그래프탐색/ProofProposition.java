import java.io.*;
import java.util.*;

public class ProofProposition {
  public static int stoi(String str) {
    return Integer.parseInt(str);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    boolean[][] array = new boolean[123][123]; // A(65)~z(122)까지를 저장
    
    int N = stoi(br.readLine());
    for (int i=0; i<N; i++) {
      String temp = br.readLine();
      int start = temp.charAt(0);
      int end = temp.charAt(5);
      
      array[start][end] = true;
    }
    
    // 중간 노드를 하나 거쳐서 성립될 수 있는 명제들 확인
    for (int i=0; i<array.length; i++) { // 거쳐가는 노드
      for (int j=0; j<array.length; j++) { // 시작 노드
        for (int k=0; k<array.length; k++) { // 끝 노드
          if (j==k) {
            continue;
            
          }
          
          if (array[j][i] && array[i][k]) {
            array[j][k] = true;
          }
        }
      }
    }
    
    // 참인 명제 찾아서 출력
    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<array.length; i++) {
      for (int j=0; j<array.length; j++) {
        if (array[i][j]) {
          if (i==j) { // 전건과 후건이 같은 명제가 참인 경우는 출력하지 안흥ㅁ
            continue;
          }
          count++;
          sb.append("\n" + (char)i + " => " + (char)j);
        }
      }
    }
    
    System.out.print(count);
    System.out.println(sb);
  }
}
