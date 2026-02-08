import java.awt.Point;
import java.io.*;
import java.util.*;

public class PopulationMoving_16234 {
  
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int N;
  private static int L;
  private static int R;
  private static int[][][] areas;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    
    areas = new int[N][N][2];
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j=0; j<N; j++) {
        areas[i][j][0] = Integer.parseInt(st.nextToken());
        areas[i][j][1] = areas[i][j][0];
      }
    }
    
    int time = 0;
    while(true) {
      boolean isMoved = false;
      boolean[][] isVisited = new boolean[N][N];
      for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
          if (!isVisited[i][j]) {
            if (bfs(j, i, isVisited) && !isMoved) {
              isMoved = true;
            }
          }
        }
      }
      
      if (!isMoved) {
        System.out.println(time);
        break;
      } else {
        for (int i=0; i<N; i++) {
          for (int j=0; j<N; j++) {
            areas[i][j][0] = areas[i][j][1];
          }
        }
      }
      
      time++;
    }
  }
  
  private static boolean bfs(int x, int y, boolean[][] isVisited) {
    List<Point> points = new ArrayList<>();
    points.add(new Point(x, y));
    
    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(x, y));
    isVisited[y][x] = true;
    int sum = areas[y][x][0];
    int count = 1;
    while(!queue.isEmpty()) {
      Point current = queue.poll();
      for (int i=0; i<4; i++) {
        int cx = current.x + dx[i];
        int cy = current.y + dy[i];
        if (0 <= cx && cx < N && 0 <= cy && cy < N) {
          int diff = Math.abs(areas[current.y][current.x][0] - areas[cy][cx][0]);
          if (!isVisited[cy][cx] && L <= diff && diff <= R) {
            queue.offer(new Point(cx, cy));
            isVisited[cy][cx] = true;
            sum += areas[cy][cx][0];
            count++;
            points.add(new Point(cx, cy));
          }
        }
      }
    }
    if (count > 1) {
      for (Point point : points) {
        areas[point.y][point.x][1] = sum / count;
      }
      return true;
    }
    return false;
  }
}
