import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gasstation_13305 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static long stol(String str) {
        return Long.parseLong(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        long[] distance = new long[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++) {
            distance[i] = stoi(st.nextToken());
        }

        long[] cost = new long[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cost[i] = stoi(st2.nextToken());
        }

        long sum = 0;
        long min = Long.MAX_VALUE;
        for (int i=0; i<N-1; i++) {
            min = Math.min(min, cost[i]);
            sum = sum + (min * distance[i]);
        }

        System.out.println(sum);
    }
}