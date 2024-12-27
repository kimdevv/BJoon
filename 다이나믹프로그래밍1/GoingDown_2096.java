import java.io.*;
import java.util.*;

public class GoingDown_2096 {
  private static int N; // 줄의 개수
  private static int[][] numbers;
  private static int[][] dpMax;
  private static int[][] dpMin;
  
  private static BufferedReader bufferedReader;
  
  public static void main(String[] args) throws IOException {
    initializeBufferedReader();
    inputNumbers();
    processDP();
    outputResult();
  }
  
  private static void initializeBufferedReader() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }
  
  private static void inputNumbers() throws IOException {
    N = Integer.parseInt(bufferedReader.readLine());
    numbers = new int[N][3];
    for (int i=0; i<N; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      numbers[i][0] = Integer.parseInt(stringTokenizer.nextToken());
      numbers[i][1] = Integer.parseInt(stringTokenizer.nextToken());
      numbers[i][2] = Integer.parseInt(stringTokenizer.nextToken());
    }
  }
  
  private static void processDP() {
    getMax();
    getMin();
  }
  
  private static void getMax() {
    dpMax = new int[N][3];
    for (int i=0; i<3; i++) {
      dpMax[0][i] = numbers[0][i];
    }
    
    for(int i=1; i<N; i++) {
      dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + numbers[i][0];
      dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + numbers[i][1];
      dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + numbers[i][2];
    }
  }
  
  private static void getMin() {
    dpMin = new int[N][3];
    for (int i=0; i<3; i++) {
      dpMin[0][i] = numbers[0][i];
    }
    
    for(int i=1; i<N; i++) {
      dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + numbers[i][0];
      dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + numbers[i][1];
      dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + numbers[i][2];
    }
  }
  
  private static void outputResult() {
    System.out.print(Math.max(dpMax[N-1][0], Math.max(dpMax[N-1][1], dpMax[N-1][2])));
    System.out.print(" ");
    System.out.print(Math.min(dpMin[N-1][0], Math.min(dpMin[N-1][1], dpMin[N-1][2])));
  }
}
