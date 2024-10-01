import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ATM_11399 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] arr = new int[N];

        int tmp = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i=0; i<N; i++) {
            tmp = tmp + arr[i];
            sum = sum  + tmp;
        }

        System.out.println(sum);
    }
}