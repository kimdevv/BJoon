import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flipping_5585 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        char startNum = S.charAt(0);

        int result = 0;
        for (int i=1; i<S.length(); i++) {
            if (S.charAt(i) != startNum && S.charAt(i-1) == startNum) {
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}