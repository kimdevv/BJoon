import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Lie_1043 {
    private static BufferedReader bufferedReader;
    private static int N; // 도시의 개수
    private static int M; // 버스의 수
    private static List<Bus>[] buses;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputNM();
        inputBuses();
        findMinimumCost();
        bufferedReader.close();
    }

    private static void inputNM() throws IOException {
        N = Integer.valueOf(bufferedReader.readLine());
        M = Integer.valueOf(bufferedReader.readLine());
    }

    private static void inputBuses() throws IOException {
        buses = new List[N+1];
        for (int i=1; i<=N; i++) {
            buses[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            StringTokenizer rawBus = new StringTokenizer(bufferedReader.readLine(), " ");
            int start = Integer.valueOf(rawBus.nextToken());
            int destination = Integer.valueOf(rawBus.nextToken());
            int cost = Integer.valueOf(rawBus.nextToken());
            buses[start].add(new Bus(destination, cost));
        }
    }

    private static void findMinimumCost() throws IOException {
        StringTokenizer startAndDestination = new StringTokenizer(bufferedReader.readLine(), " ");
        int start = Integer.valueOf(startAndDestination.nextToken());
        int destination = Integer.valueOf(startAndDestination.nextToken());
        dijkstra(start, destination);
    }

    private static void dijkstra(int start, int destination) {
        long[] costs = new long[N+1];
        Arrays.fill(costs, 100_000_000);
        costs[start] = 0;

        Queue<Bus> queue = new PriorityQueue<>();
        for (Bus bus : buses[start]) {
            if (costs[bus.destination] > bus.cost) {
                costs[bus.destination] = bus.cost;
                queue.offer(bus);
            }
        }

        while (true) {
            Bus current = queue.poll();
            if (current.destination == destination) {
                System.out.println(costs[destination]);
                return;
            }
            for (Bus next : buses[current.destination]) {
                if (costs[next.destination] > costs[current.destination] + next.cost) {
                    costs[next.destination] = costs[current.destination] + next.cost;
                    queue.offer(new Bus(next.destination, costs[next.destination]));
                }
            }
        }
    }

    private static class Bus implements Comparable<Bus> {
        private int destination;
        private long cost;

        public Bus(int destination, long cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus other) {
            return (int)this.cost - (int)other.cost;
        }
    }
}