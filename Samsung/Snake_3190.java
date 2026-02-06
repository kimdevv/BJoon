import java.awt.*;
import java.io.*;
import java.util.*;

public class Snake_3190 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    boolean[][] apples = new boolean[N + 1][N + 1];
    
    int K = Integer.parseInt(br.readLine());
    for (int i=0; i<K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      apples[y][x] = true;
    }
    
    int L = Integer.parseInt(br.readLine());
    int[][] changes = new int[L][2];
    for (int i=0; i<L; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      changes[i][0] = Integer.parseInt(st.nextToken());
      changes[i][1] = st.nextToken().charAt(0);
    }
    
    Deque<Point> deque = new ArrayDeque<>();
    deque.addFirst(new Point(1,1));
    boolean[][] isBlocked = new boolean[N + 1][N + 1];
    isBlocked[1][1] = true;
    int time = 0;
    int direction = 0;
    int x = 1;
    int y = 1;
    while (true) {
      time++;
      
      if (direction == 0) { // 오른
        x++;
      } else if (direction == 1) { // 왼
        x--;
      } else if (direction == 2) { // 위
        y--;
      } else { // 아래
        y++;
      }
      if (!(1 <= x && x <= N && 1 <= y && y <= N) || isBlocked[y][x]) {
        System.out.println(time);
        break;
      }
      
      deque.addFirst(new Point(x, y));
      isBlocked[y][x] = true;
      
      if (apples[y][x]) {
        apples[y][x] = false;
      } else {
        Point removed = deque.removeLast();
        isBlocked[removed.y][removed.x] = false;
      }
      
      for (int[] change : changes) {
        if (time == change[0]) {
          direction = changeDirection(direction, (char) change[1]);
        }
      }
    }
  }
  
  private static int changeDirection(int direction, char change) {
    if (direction == 0) {
      if (change == 'L') {
        return 2;
      } else {
        return 3;
      }
    } else if (direction == 1) {
      if (change == 'L') {
        return 3;
      } else {
        return 2;
      }
    } else if (direction == 2) {
      if (change == 'L') {
        return 1;
      } else {
        return 0;
      }
    } else {
      if (change == 'L') {
        return 0;
      } else {
        return 1;
      }
    }
  }
}
