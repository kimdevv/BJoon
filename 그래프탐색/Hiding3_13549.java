import java.io.*;
import java.util.*;

public class Hiding3_13549 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
    int K = Integer.parseInt(st.nextToken()); // 동생의 위치
    
    int[] costs = new int[200_002];
    Arrays.fill(costs, Integer.MAX_VALUE);
    
    PriorityQueue<Route> queue = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
    queue.offer(new Route(N, 0));
    while (!queue.isEmpty()) {
      Route current = queue.poll();
      costs[current.location] = current.cost;
      
      if (current.location == K) {
        System.out.println(current.cost);
        break;
      }
      
      if (current.location - 1 >= 0 && current.cost + 1 < costs[current.location - 1]) {
        queue.offer(new Route(current.location - 1, current.cost + 1));
      }
      if (current.location + 1 <= 200_000 && current.cost + 1 < costs[current.location + 1]) {
        queue.offer(new Route(current.location + 1, current.cost + 1));
      }
      if (current.location * 2 <= 200_000 && current.cost < costs[current.location * 2]) {
        queue.offer(new Route(current.location * 2, current.cost));
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
