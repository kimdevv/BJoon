import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Microwave_10162 {

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