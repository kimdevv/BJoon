import java.io.*;
import java.util.*;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class FindDistanceOfSpecificCity_18352 {

    private static int N; // 도시의 개수
    private static int M; // 도로의 개수
    private static int K; // 거리 정보
    private static int X; // 출발 도시의 번호
    private static ArrayList[] graph;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        input();
        bfs(X);
        outputResult();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;
        graph = new ArrayList[N+1];
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }

        br.close();
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int i=0; i<graph[currentNode].size(); i++) {
                int nextNode = (int) graph[currentNode].get(i);
                if (distance[nextNode] == Integer.MAX_VALUE) {
                    distance[nextNode] = distance[currentNode] + 1;
                    queue.add(nextNode);
                }
            }
        }
    }

    private static void outputResult() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<distance.length; i++) {
            if (distance[i] == K) {
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}
