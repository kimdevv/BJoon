import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneNumber_1065 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int [1001];

        // 1부터 99까지는 모두 등차수열
        for (int i=1; i<=99; i++) {
            list[i] = 1;
        }

        // 100 이상의 수부터 한수인지 검사
        for (int i=100; i<1001; i++) {
            int no = i;
            int diff = (no%10) - ((no/10)%10); // 두 값의 차이
            no /= 10;

            // 한자리 수만 남을 때까지 계속 10으로 나누면서
            while (no > 9) {
                if ((no%10) - ((no/10)%10) == diff) { // 인접한 두 수의 차이가 diff와 같은지 검사
                    list[i] = 1; // 같으면 1로 바꿈
                } else {
                    list[i] = 0; // 안 차례라도 다르면 0
                    break;
                }
                no /= 10;
            }
        }

        int N = stoi(br.readLine());
        int count = 0;
        for (int i=1; i<=N; i++) {
            if (list[i] == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
