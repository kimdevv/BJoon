import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

public class ShortestRoute_1753 {
    private static BufferedReader bufferedReader;
    private static int V; // 정점의 개수
    private static int E; // 간선의 개수
    private static int K; // 시작 정점의 번호
    private static List<Node>[] graph;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputVEK();
        inputNodes();
        traverseGraph();
        outputResult();
        bufferedReader.close();
    }

    private static void inputVEK() throws IOException {
        StringTokenizer VEK = new StringTokenizer(bufferedReader.readLine());
        V = Integer.valueOf(VEK.nextToken());
        E = Integer.valueOf(VEK.nextToken());
        K = Integer.valueOf(bufferedReader.readLine());
    }

    private static void inputNodes() throws IOException {
        graph = new ArrayList[V+1];
        for (int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<E; i++) {
            StringTokenizer rawNode = new StringTokenizer(bufferedReader.readLine()," ");
            int start = Integer.valueOf(rawNode.nextToken());
            int end = Integer.valueOf(rawNode.nextToken());
            int weight = Integer.valueOf(rawNode.nextToken());
            graph[start].add(new Node(end, weight));
        }
    }

    private static void traverseGraph() {
        distance = new int[V+1];
        boolean[] isVisited = new boolean[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (isVisited[currentNode.end]) {
                continue;
            }

            isVisited[currentNode.end] = true;
            for (Node nextNode : graph[currentNode.end]) {
                if (distance[nextNode.end] > distance[currentNode.end] + nextNode.weight) {
                    distance[nextNode.end] = distance[currentNode.end] + nextNode.weight;
                    queue.add(new Node(nextNode.end, distance[nextNode.end]));
                }
            }
        }
    }

    private static void outputResult() {
        for (int i=1; i<=V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }


    public static class Node implements Comparable<Node> {
        public int end;
        public int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }
}