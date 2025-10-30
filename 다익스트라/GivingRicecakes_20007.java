import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GivingRicecakes_20007 {

    private static int N; // 집의 개수
    private static int M; // 도로의 개수
    private static int X; // 하루에 걷는 최대 거리
    private static int Y; // 성현이의 집
    private static List<Route>[] graph;
    private static boolean[] isVisited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        graph = new List[N];
        for (int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[node1].add(new Route(node2, cost));
            graph[node2].add(new Route(node1, cost));
        }

        isVisited = new boolean[N];
        int[] costs = new int[N];
        Arrays.fill(costs, 1_000_000_000);
        costs[Y] = 0;

        PriorityQueue<Route> pq = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
        pq.offer(new Route(Y, 0));
        while (!pq.isEmpty()) {
            Route current = pq.poll();
            isVisited[current.destination] = true;

            for (Route next : graph[current.destination]) {
                int nextCost = costs[current.destination] + next.cost;
                if (!isVisited[next.destination] && nextCost <= costs[next.destination]) {
                    costs[next.destination] = nextCost;
                    pq.offer(new Route(next.destination, nextCost));
                }
            }
        }

        Arrays.sort(costs);
        int sum = 0;
        int days = 1;
        for (int i=0; i<N; i++) {
            if (costs[i] * 2 > X) {
                days = -1;
                break;
            }
            sum += (costs[i] * 2);
            if (sum > X) {
                days++;
                sum = costs[i] * 2;
            }
        }
        System.out.println(days);
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
