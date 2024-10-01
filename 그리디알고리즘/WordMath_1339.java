import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class WordMath_1339 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] arr = new Integer[91];
        for (int i=0; i<91; i++) {
            arr[i] = 0;
        }

        int N = stoi(br.readLine());
        for (int i=0; i<N; i++) {
            String num = br.readLine();
            int ten = 1;
            for (int j=0; j<num.length(); j++) {
                char temp = num.charAt(num.length()-1-j);
                arr[temp] += ten;
                ten *= 10;
            }
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int result = 0;
        int nine = 9;
        for (int i=0; arr[i] != 0;i++) {
            result += (arr[i] * nine);
            nine--;
        }

        System.out.println(result);

        br.close();
    }
}