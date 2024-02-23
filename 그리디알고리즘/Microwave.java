import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.StringBuilder;

public class Microwave {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        
        if (T % 10 != 0) {
          System.out.println(-1);
        } else {
          int A = T / 300;
          T %= 300;
          
          int B = T / 60;
          T %= 60;
          
          int C = T / 10;
          System.out.println(A + " " + B + " " + C);
        }
    }
}
