import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class KevinBacon6Rule_1389 {

    private static int N; // 유저의 수
    private static int M; // 친구 관계의 수
    private static List<Integer>[] graph;
    private static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            graph[person1].add(person2);
            graph[person2].add(person1);
        }

        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        for (int i=1; i<=N; i++) {
            int person = i;

            boolean[] isVisited = new boolean[N + 1];
            int[] distance = new int[N + 1];
            Arrays.fill(distance, INF);
            distance[person] = 0;

            PriorityQueue<Route> pq = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
            pq.offer(new Route(person, 0));
            isVisited[person] = true;
            while (!pq.isEmpty()) {
                Route current = pq.poll();
                for (int next : graph[current.destination]) {
                    if (!isVisited[next] && current.cost + 1 < distance[next]) {
                        isVisited[next] = true;
                        distance[next] = current.cost + 1;
                        pq.offer(new Route(next, current.cost + 1));
                    }
                }
            }
            int sum = 0;
            for (int j=1; j<=N; j++) {
                sum += distance[j];
            }
            if (sum < min) {
                min = sum;
                minIndex = person;
            }
        }
        System.out.println(minIndex);
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