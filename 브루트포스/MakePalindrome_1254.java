import java.io.*;

public class MakePalindrome_1254 {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String S = br.readLine();
      
      for (int i=0; i<S.length(); i++) {
        String tmp = S.substring(i);
        
        String restmp = "";
        // i번째 인덱스부터 단어를 자름
        for (int j=tmp.length()-1; j>=0; j--) {
          restmp += tmp.charAt(j);
        }
        
        if (tmp.equals(restmp)) { // 자른 단어가 뒤집어도 똑같다면
          int size = restmp.length() + (2*i); // 그 때 앞뒤로 남은 단어를 붙인 길이를 구함
          System.out.println(size);
          break;
        }
      }
      
  }
}
