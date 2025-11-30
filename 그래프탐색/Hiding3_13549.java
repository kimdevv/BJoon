import java.io.*;
import java.util.*;

public class Hiding3_13549 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
    int K = Integer.parseInt(st.nextToken()); // 동생의 위치
    
    int[] cost = new int[100_001];
    Arrays.fill(cost, Integer.MAX_VALUE);
    Deque<Route> deque = new ArrayDeque<>();
    deque.offerFirst(new Route(N, 0));
    while (!deque.isEmpty()) {
      Route current = deque.pollFirst();
      cost[current.location] = current.cost;
      if (current.location == K) {
        System.out.println(current.cost);
        break;
      }
      
      if (current.location - 1 >= 0 && current.cost + 1 < cost[current.location - 1]) {
        deque.offerLast(new Route(current.location - 1, current.cost + 1));
      }
      if (current.location + 1 <= 100_000 && current.cost + 1 < cost[current.location + 1]) {
        deque.offerLast(new Route(current.location + 1, current.cost + 1));
      }
      if (current.location * 2 <= 100_000 && current.cost < cost[current.location * 2]) {
        deque.offerFirst(new Route(current.location * 2, current.cost));
      }
    }
    br.close();
  }
  
  private static class Route {
    
    private final int location;
    private final int cost;
    
    private Route(int location, int cost) {
      this.location = location;
      this.cost = cost;
    }
  }
}
