import java.io.*;
import java.util.*;

public class FindingNumber_1920 {
  public static int stoi(String string) {
    return Integer.parseInt(string);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int N = stoi(stringTokenizer.nextToken()); // 자연수의 개수
    int[] array = new int[N];
    
    // 입력받은 자연수를 오름차순으로 정렬
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i=0; i<N; i++) {
      array[i] = stoi(stringTokenizer.nextToken());
    }
    Arrays.sort(array);
    
    int M = stoi(bufferedReader.readLine()); // 케이스의 개수
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i=0; i<M; i++) {
      int findValue = stoi(stringTokenizer.nextToken());
      
      System.out.println(binarySearch(array, findValue, 0, array.length) ? 1 : 0);
    }
  }
  
  public static boolean binarySearch(int[] array, int findValue, int start, int end) {
    int middle = (start + end) / 2; // 중간값 (소숫점은 버림)
    
    if (start > middle || middle >= end) { // 종료조건
      return false;
    } else if (array[middle] > findValue) { // 찾으려는 값이 더 작다면 왼쪽 배열로 들어감
      return binarySearch(array, findValue, start, middle); 
    } else if (array[middle] < findValue) { // 찾으려는 값이 더 크다면 오른쪽 배열로 들어감
      return binarySearch(array, findValue, middle+1, end);
    } else { // if (array[middle] == findValue)
      return true;
    }
  }
}
