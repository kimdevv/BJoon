import java.io.*;
import java.util.*;

public class SumOfTwoNumbers_3273 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    int[] numbers = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(numbers);
    
    int x = Integer.parseInt(br.readLine());
    int count = binarySearch(x, numbers);
    System.out.println(count);
    
    br.close();
  }
  
  private static int binarySearch(int target, int[] numbers) {
    int count = 0;
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      
      if (sum > target) {
        right--;
      } else if (sum < target) {
        left++;
      } else {
        int upperBound = findUpperBoundOf(numbers[right], left + 1, numbers);
        int lowerBound = findLowerBoundOf(numbers[right], left + 1, numbers);
        count += (upperBound - lowerBound);
        left++;
      }
    }
    return count;
  }
  
  private static int findUpperBoundOf(int number, int startIndex, int[] numbers) {
    int left = startIndex;
    int right = numbers.length;
    while (left < right) {
      int mid = (left + right) / 2;
      int midValue = numbers[mid];
      if (midValue > number) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }
  
  private static int findLowerBoundOf(int number, int startIndex, int[] numbers) {
    int left = startIndex;
    int right = numbers.length;
    while (left < right) {
      int mid = (left + right) / 2;
      int midValue = numbers[mid];
      if (midValue >= number) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }
}
