import java.io.*;

public class DirectorShom_1436 {
    public static int stoi (String str) {
      return Integer.parseInt(str);
    }
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int[] array = new int[10001];
      array[0] = 666;
      
      int lastCount = 0; // 마지막 수
      for (int i=0; i<10001; i++) {
        if (Integer.toString(lastCount).contains("666")) { // 666이 포함되어 있다면
          // 000~999까지 모든 수가 그 아래로 들어갈 수 있다.
          for (int j=0; j<1000; j++) {
            if (i+j < 10001) {
              array[i+j] = lastCount*1000 + j;
            }
          }
          i+=999;
        } else if (lastCount%100 == 66) { // 66으로 끝난다면
          // 600~699까지의 수가 그 아래로 들어갈 수 있다.
          for (int j=0; j<100; j++) {
            if (i+j < 10001) {
              array[i+j] = lastCount*1000 + 600 + j;
            }
          }
          i+=99;
        } else if (lastCount%10 == 6) { // 6으로 끝끝난다면
          // 660~669까지의 수가 그 아래로 들어갈 수 있다.
          for (int j=0; j<10; j++) {
            if (i+j < 10001) {
              array[i+j] = lastCount*1000 + 660 + j;
            }
          }
          i+=9;
        } else { // 6이 끝에 포함되지 않으면
          array[i] = lastCount*1000 + 666; // 맨 뒤에 666을 붙인다
        }
        lastCount++;
      }
      
      int N = stoi(br.readLine());
      System.out.println(array[N-1]);
  }
}
