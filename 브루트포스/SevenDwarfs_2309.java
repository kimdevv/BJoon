import java.util.*;
import java.io.*;

public class SevenDwarfs_2309 {
    public static int stoi(String str) {
      return Integer.parseInt(str);
    }
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int sum = 0;
      int[] dwarf = new int[9];
      for (int i=0; i<9; i++) {
        int tmp = stoi(br.readLine());
        dwarf[i] = tmp;
        sum += tmp;
      }
      Arrays.sort(dwarf);
      
      int diff = sum - 100; // 합계와 100간의 차이를 구함
      a: for(int i=0; i<8; i++) {
        for (int j=(i+1); j<9; j++) {
          if (dwarf[i]+dwarf[j] == diff) { // 차이 나게 하는 두 난쟁이를 구하면
            dwarf[i] = 0; // 키를 0으로 만들어 배제시킨다
            dwarf[j] = 0;
            diff = 9999; // break;는 내부for문만 벗어날 수 있으므로 diff를 바꿔서 조건이 더 만족되지 않게 바꿔준다
          }
        }
      }
      Arrays.sort(dwarf);

      // 키가 0이 아닌 난쟁이들의 키 출력      
      for (int i=2; i<9; i++) {
        System.out.println(dwarf[i]);
      }
  }
}
