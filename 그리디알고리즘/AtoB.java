import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double A = stoi(st.nextToken());
        double B = stoi(st.nextToken());

        int sum = 0;

        while ((long)B > (long)A) {
            sum++;
            if ((long)B%10 == 1) {
                B -= 1;
                B /= 10;
            } else {
                B /= 2;
            }
        }

        if ((long)(B*10) == (long)(A*10)) {
            System.out.println(sum + 1);
        } else {
            System.out.println(-1);
        }

    }
}