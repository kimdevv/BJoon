import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Hiding_1697 {

    private static int N; // 수빈이의 현재 위치
    private static int K; // 동생이 있는 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = -1;
        boolean[] isVisited = new boolean[200_001];
        PriorityQueue<Route> pq = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
        pq.offer(new Route(N, 0));
        while (!pq.isEmpty()) {
            Route current = pq.poll();
            isVisited[current.destination] = true;
            if (current.destination == K) {
                result = current.cost;
                break;
            }

            if (current.destination + 1 <= 100_000 && !isVisited[current.destination + 1]) {
                pq.offer(new Route(current.destination + 1, current.cost + 1));
            }
            if (current.destination * 2 <= 100_000 && !isVisited[current.destination * 2]) {
                pq.offer(new Route(current.destination * 2, current.cost + 1));
            }
            if (current.destination - 1 >= 0 && !isVisited[current.destination - 1]) {
                pq.offer(new Route(current.destination - 1, current.cost + 1));
            }
        }

        System.out.println(result);
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