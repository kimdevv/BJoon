import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus {
    static int N; // 컴퓨터의 수
    static int M; // 간선의 수
    static int[][] array; // 간선
    static boolean[] isVisited; // 방문한 정점인지?
    static Queue<Integer> queue = new LinkedList<Integer>();
    static int count = 0; // 출력할 개수

    public static int stoi(String string) {
        return Integer.parseInt((string));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        M = stoi(br.readLine());
        array = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = stoi(st.nextToken());
            int num2 = stoi(st.nextToken());
            array[num1][num2] = 1;
            array[num2][num1] = 1;
        }

        int start = 1;
        bfs(start);

        System.out.println(count);
    }

    public static void bfs(int start) {
        isVisited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i=1; i<=N; i++) {
                if (array[vertex][i]==1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    count++;
                }
            }
        }
    }
}
