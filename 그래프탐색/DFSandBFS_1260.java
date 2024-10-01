import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class DFSandBFS_1260 {
    static int N, M, V;
    static boolean[] isVisited;
    static int[][] array;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // 정점의 개수
        M = stoi(st.nextToken()); // 간선의 개수
        V = stoi(st.nextToken()); // 탐색을 시작할 정점의 번호

        isVisited = new boolean[N+1];
        array = new int[N+1][N+1];
        for (int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer((br.readLine()));
            int tempNum1 = stoi(st2.nextToken());
            int tempNum2 = stoi(st2.nextToken());
            array[tempNum1][tempNum2] = 1; // 해당 간선이 존재한다
            array[tempNum2][tempNum1] = 1;
        }

        dfs(V);
        sb.append("\n");
        isVisited = new boolean[N+1];

        bfs(V);
        System.out.print(sb);
    }

    public static void dfs(int start) {
        isVisited[start] = true;
        sb.append(start + " ");

        // 노드 당 N번 반복하면서 재귀
        for (int i=1; i<=N; i++) {
            if (array[start][i] == 1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        // 처음 방문 노드로 큐 초기화
        queue.add(start);
        isVisited[start] = true;

        // 재귀 대신 큐를 활용한 반복문 사용
        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for (int i=1; i<=N; i++) {
                if (array[start][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
