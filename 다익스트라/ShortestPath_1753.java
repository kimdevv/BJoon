import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class ShortestPath_1753 {

    private static int V; // 정점의 개수
    private static int E; // 간선의 개수
    private static int K; // 시작 정점의 번호
    private static List<Route>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new List[V + 1];
        for (int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        int from, to, cost;
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Route(to, cost));
        }

        boolean[] isVisited = new boolean[V + 1];
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        PriorityQueue<Route> pq = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
        pq.add(new Route(K, 0));
        while (!pq.isEmpty()) {
            Route current = pq.poll();

            if (isVisited[current.destination]) {
                continue;
            }
            isVisited[current.destination] = true;

            for (Route next : graph[current.destination]) {
                if (distance[next.destination] >= distance[current.destination] + next.cost) {
                    distance[next.destination] = distance[current.destination] + next.cost;
                    pq.offer(new Route(next.destination, distance[next.destination]));
                }
            }
        }

        for (int i=0; i<V; i++) {
            System.out.println(distance[i + 1] == Integer.MAX_VALUE ? "INF" : distance[i + 1]);
        }
    }

    private static class Route {

        private int destination;
        private int cost;

        private Route(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}