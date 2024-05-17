import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rope {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        int[] weight = new int[N];
        for (int i=0; i<N; i++) {
            weight[i] = stoi(br.readLine());
        }

        Arrays.sort(weight);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            int tmp = weight[i] * (N-i);
            max = Math.max(max, tmp);
        }

        System.out.println(max);
    }
}