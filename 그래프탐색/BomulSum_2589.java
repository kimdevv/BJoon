import java.awt.Point;
import java.io.*;
import java.util.*;

public class BomulSum_2589 {
  
  private static int x;
  private static int y;
  private static int[][] areas;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {1, -1, 0, 0};
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    
    areas = new int[y][x];
    for (int i=0; i<y; i++) {
      String line = br.readLine();
      for (int j=0; j<x; j++) {
        areas[i][j] = line.charAt(j);
      }
    }
    
    int max = -1;
    for (int i=0; i<y; i++) {
      for (int j=0; j<x; j++) {
        if (areas[i][j] == 'L') {
          int result = bfs(new Move(j, i, 0));
          max = Math.max(max, result);
        }
      }
    }
    
    System.out.println(max);
    br.close();
  }
  
  private static int bfs(Move start) {
    boolean[][] isVisited = new boolean[y][x];
    isVisited[start.y][start.x] = true;
// System.out.println("시작 " + start.x + " " + start.y);
    int maxDistance = -1;
    Queue<Move> queue = new ArrayDeque<>();
    queue.offer(start);
    while (!queue.isEmpty()) {
      Move current = queue.poll();
      maxDistance = Math.max(maxDistance, current.distance);
// System.out.println(current.x + " " + current.y + " " + current.distance);
      for (int i=0; i<4; i++) {
        int nextX = current.x + dx[i];
        int nextY = current.y + dy[i];
        if (0 <= nextX && nextX < x && 0 <= nextY && nextY < y) {
          if (!isVisited[nextY][nextX] && areas[nextY][nextX] == 'L') {
            queue.offer(new Move(nextX, nextY, current.distance + 1));
            isVisited[nextY][nextX] = true;
          }
        }
      }
    }
    
    return maxDistance;
  }
  
  private static class Move {
    
    private final int x;
    private final int y;
    private final int distance;
    
    private Move(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }
}
