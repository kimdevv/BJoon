import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SugarDelivery {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        int N = stoi(br.readLine());
        while (N > 0) {
            //System.out.println("N : " + N);
            if (N%5 == 0) {
                count += N/5;
                break;
            } else if (N < 3) {
                count = -1;
                break;
            } else {
                N -= 3;
                count ++;
            }
        }

        System.out.println(count);
    }
}