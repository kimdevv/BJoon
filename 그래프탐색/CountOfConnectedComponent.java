import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountOfConnectedComponent {
    static int N;
    static int M;
    static int[][] array;
    static boolean[] isVisited;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        array = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int num1 = stoi(st2.nextToken());
            int num2 = stoi(st2.nextToken());

            array[num1][num2] = 1;
            array[num2][num1] = 1;
        }

        int count = 0;
        for (int i=1; i<=N; i++) {
            if (!isVisited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start) {
        isVisited[start] = true;
        for (int i=1; i<=N; i++) {
            if (array[start][i]==1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }
}