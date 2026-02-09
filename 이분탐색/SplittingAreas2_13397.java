import java.io.*;
import java.util.*;

public class SplittingAreas2_13397 {
  
  private static int N;
  private static int M;
  private static int[] numbers;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    numbers = new int[N];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i=0; i<N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    
    int left = 0;
    int right = 2_000_000_000;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (canMake(mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    
    System.out.println(left);
  }
  
  private static boolean canMake(int target) {
    int count = 1;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i=0; i<N; i++) {
      min = Math.min(min, numbers[i]);
      max = Math.max(max, numbers[i]);
      if (max - min > target) {
        count++;
        min = numbers[i];
        max = numbers[i];
      }
    }
    
    if (count > M) {
      return false;
    }
    return true;
  }
}
