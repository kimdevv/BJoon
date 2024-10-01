import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumbers_1789 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static long stol(String str) {
        return Long.parseLong(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long S = stol(br.readLine());

        long tmp = 1;
        long count = 0;
        while(S-tmp >= 0) {
            S -= tmp;

            count++;
            tmp++;
        }

        System.out.println(count);
    }
}