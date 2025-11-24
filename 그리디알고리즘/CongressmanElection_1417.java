import java.io.*;
import java.util.*;

public class CongressmanElection_1417 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine()); // 후보의 수
    
    int[] pyos = new int[N];
    for (int i=0; i<N; i++) {
      pyos[i] = Integer.parseInt(br.readLine());
    }
    
    int count = 0;
    while (true) {
      int max = Integer.MIN_VALUE;
      int maxIndex = -1;
      for (int i=1; i<N; i++) {
        if (pyos[i] > max) {
          max = pyos[i];
          maxIndex = i;
        }
      }
      
      if (pyos[0] > max) {
        break;
      }
      
      count++;
      pyos[maxIndex]--;
      pyos[0]++;
    }
    
    System.out.println(count);
    br.close();
  }
}
