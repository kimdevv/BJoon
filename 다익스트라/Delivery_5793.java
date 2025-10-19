import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Delivery_5793 {

    private static int N; // 헛간 개수
    private static int M; // 길 개수
    private static List<Route>[] routes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        routes = new ArrayList[N + 1];
        for (int i=0; i<N+1; i++) {
            routes[i] =new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            routes[city1].add(new Route(city2, cost));
            routes[city2].add(new Route(city1, cost));
        }

        int[] distances = new int[N+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i=0; i<routes[current].size(); i++) {
                Route route = routes[current].get(i);
                int next = route.destination;
                if (distances[next] > distances[current] + route.cost) {
                    distances[next] = distances[current] + route.cost;
                    queue.offer(next);
                }
            }
        }

        System.out.println(distances[N]);
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
