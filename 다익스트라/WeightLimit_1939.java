import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class WeightLimit_1939 {

    private static int N; // 섬의 개수
    private static int M; // 다리의 개수
    private static List<Route>[] graph;
    private static int from, to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Route(end, cost));
            graph[end].add(new Route(start, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int[] weight = new int[N + 1];

        PriorityQueue<Route> pq = new PriorityQueue<>((r1, r2) -> r2.cost - r1.cost);
        pq.offer(new Route(from, Integer.MAX_VALUE));
        while(!pq.isEmpty()) {
            Route current = pq.poll();

            if (current.destination == to) {
                break;
            }

            for (Route next : graph[current.destination]) {
                if (Math.min(current.cost, next.cost) > weight[next.destination]) {
                    weight[next.destination] = Math.min(current.cost, next.cost);
                    pq.offer(new Route(next.destination, weight[next.destination]));
                }
            }
        }

        System.out.println(weight[to]);
        br.close();
    }

    private static class Route {

        private final int destination;
        private final int cost;

        private Route(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}
