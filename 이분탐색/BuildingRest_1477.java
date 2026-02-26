import java.io.*;
import java.util.*;

public class BuildingRest_1477 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
    int M = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소 개수
    int L = Integer.parseInt(st.nextToken()); // 고속도로의 길이
    
    List<Integer> route = new ArrayList<>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i=0; i<N; i++) {
      route.add(Integer.parseInt(st.nextToken()));
    }
    route.add(0);
    route.add(L);
    Collections.sort(route);
    
    int max = Integer.MAX_VALUE;
    int left = 1;
    int right = 1000;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (canBuild(mid, route, M)) {
        right = mid - 1;
        max = mid;
      } else {
        left = mid + 1;
      }
    }
    
    System.out.println(max);
    br.close();
  }
  
  private static boolean canBuild(int gap, List<Integer> route, int moreCount) {
    int can = moreCount;
    for (int i=0; i<route.size() -1; i++) {
      int loc1 = route.get(i);
      int loc2 = route.get(i + 1);
      int distance = loc2 - loc1;
      if (distance > gap) {
        int buildCount = distance / gap;
        if (distance % gap == 0) {
          buildCount--;
        }
        if (moreCount >= buildCount) {
          moreCount -= buildCount;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
