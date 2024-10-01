import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0_11047 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = stoi(br.readLine());
        }

        int count = 0;
        for (int i=N-1; i>=0; i--) {
            if (K >= arr[i]) {
                count += K/arr[i];
                K %= arr[i];
            }
        }

        System.out.println(count);
    }
}