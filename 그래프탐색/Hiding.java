import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hiding {
    static int N;
    static int K;
    static int[] array = new int[200002];

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        for (int i=N; i<=K; i++) {
            array[i] = i;
        }

        dfs(N);
        System.out.println(array[K]);
    }

    public static void dfs(int start) {
        int[] move = {1, -1, start};

        for (int i=0; i<3; i++) {
            int cx = array[start] + move[i];
            if (array[cx] > cx) {
                array[cx] = cx;
            }
            if (cx <= K) {
                dfs(cx);
            }
        }
    }
}