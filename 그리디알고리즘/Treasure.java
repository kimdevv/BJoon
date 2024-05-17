import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.StringBuilder;

public class Treasure {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] arrayA = new int[N];
        int[] arrayB = new int[N];

        StringTokenizer st_a = new StringTokenizer(br.readLine());
        StringTokenizer st_b = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arrayA[i] = stoi(st_a.nextToken());
            arrayB[i] = stoi(st_b.nextToken());
        }

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        // A는 작은 수부터, B는 큰 수부터 차례로 곱해서 sum에 더한다.
        int sum = 0;
        for(int i=0; i<N; i++) {
            int tmp = arrayA[i] * arrayB[N-1-i];
            sum += tmp;
        }

        System.out.println(sum);
    }
}