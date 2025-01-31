import java.awt.Point;
import java.io.*;
import java.util.*;

public class WarBattle_1303 {
  private static BufferedReader bufferedReader;
  private static int N; // 가로 크기
  private static int M; // 세로 크기
  private static int ourForce; // 내 팀 병사의 위력의 합
  private static int theirForce; // 상대팀 병사의 위력의 합
  private static char[][] battleField;
  private static boolean[][] isVisited;
  
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, 1, -1};
  
  public static void main(String[] args) throws IOException {
    initializeBufferedReader();
    inputNM();
    inputSoldiers();
    traverseGraph();
    outputResult();
  }
  
  private static void initializeBufferedReader() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }
  
  private static void inputNM() throws IOException {
    StringTokenizer NM = new StringTokenizer(bufferedReader.readLine());
    N = Integer.parseInt(NM.nextToken());
    M = Integer.parseInt(NM.nextToken());
  }
  
  private static void inputSoldiers() throws IOException {
    battleField = new char[M+1][N+1];
    for (int i=1; i<=M; i++) {
      String soldierLine = bufferedReader.readLine();
      for (int j=1; j<=N; j++) {
        battleField[i][j] = soldierLine.charAt(j-1);
      }
    }
  }
  
  private static void traverseGraph() {
    isVisited = new boolean[M+1][N+1];
    for (int i=1; i<=M; i++) {
      for (int j=1; j<=N; j++) {
        if (battleField[i][j] == 'W' && !isVisited[i][j]) {
          int adjacence = bfs(i, j);
          ourForce += adjacence * adjacence;
        }
      }
    }
    
    for (int i=1; i<=M; i++) {
      for (int j=1; j<=N; j++) {
        if (battleField[i][j] == 'B' && !isVisited[i][j]) {
          int adjacence = bfs(i, j);
          theirForce += adjacence * adjacence;
        }
      }
    }
  }
  
  private static int bfs(int startY, int startX) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(startX, startY));
    
    int count = 0;
    char startChar = battleField[startY][startX];
    isVisited[startY][startX] = true;
    while (!queue.isEmpty()) {
      Point nowPoint = queue.poll();
      count++;
      for (int i=0; i<4; i++) {
        int cx = nowPoint.x + dx[i];
        int cy = nowPoint.y + dy[i];
        if (1 <= cx && cx <= N && 1 <= cy && cy <= M) {
          if (battleField[cy][cx] == startChar && !isVisited[cy][cx]) {
            isVisited[cy][cx] = true;
            queue.add(new Point(cx, cy));
          }
        }
      }
    }
    return count;
  }
  
  private static void outputResult() {
    System.out.printf("%d %d", ourForce, theirForce);
  }
}
