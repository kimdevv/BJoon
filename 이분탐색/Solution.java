import java.io.*;
import java.util.*;

public class Solution {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
    
    int[] solutions = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i=0; i<N; i++) {
      solutions[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(solutions);
    
    int min = Integer.MAX_VALUE;
    int minLeft = -1;
    int minRight = -1;
    
    int left = 0;
    int right = N - 1;
    while (left < right) {
      int sum = solutions[left] + solutions[right];
      
      if (Math.abs(sum) >= Math.abs(min)) {
        if (sum > 0) { // sum이 0보다 크면 큰 값을 줄인다 (작아지도록)
          right--;
        } else { // sum이 0보다 작으면 작은 값을 늘린다 (커지도록)
          left++;
        }
      } else {
        min = sum;
        minLeft = left;
        minRight = right;
        
        if (Math.abs(solutions[left + 1] + solutions[right]) > Math.abs(solutions[left] + solutions[right - 1])) {
          right--;
        } else {
          left++;
        }
      }
    }
    
    System.out.println(solutions[minLeft] + " " + solutions[minRight]);
  }
}
