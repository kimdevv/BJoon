import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class SpecificShortestRoute_1504 {

    private static int N; // 정점의 개수
    private static int E; // 간선의 개수
    private static List<Route>[] graph;
    private static int v1; // 반드시 거쳐야 하는 정점
    private static int v2; // 반드시 거쳐야 하는 정점

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Route(end, cost));
            graph[end].add(new Route(start, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] from1 = djikstraFrom(1);
        int[] fromV1 = djikstraFrom(v1);
        int[] fromV2 = djikstraFrom(v2);

        if (from1[v1] == Integer.MAX_VALUE || fromV1[v2] == Integer.MAX_VALUE || fromV2[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            long path1 = (long) from1[v1] + fromV1[v2] + fromV2[N];
            long path2 = (long) from1[v2] + fromV2[v1] + fromV1[N];
            System.out.println(Math.min(path1, path2));
        }

        br.close();
    }

    private static int[] djikstraFrom(int start) {
        boolean[] isVisited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Route> pq = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
        pq.offer(new Route(start, 0));

        while(!pq.isEmpty()) {
            Route current = pq.poll();

            if (isVisited[current.destination]) {
                continue;
            }
            isVisited[current.destination] = true;

            for (Route next : graph[current.destination]) {
                int nextDistance = distance[current.destination] + next.cost;
                if (distance[next.destination] >= nextDistance) {
                    distance[next.destination] = nextDistance;
                    pq.offer(new Route(next.destination, distance[next.destination]));
                }
            }
        }

        return distance;
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