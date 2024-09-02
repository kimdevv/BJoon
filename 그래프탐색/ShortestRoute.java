import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class ShortestRoute {
    static int V; // 정점의 개수
    static int E; // 간선의 개수

    public static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        int startVertex = stoi(br.readLine());
        int[] weightArray = new int[V+1];
        boolean[] isVisited = new boolean[V+1];
        List<Node>[] nodeList = new List[V+1]; // 간선을 담을 리스트. 2차원 배열로 담으면 메모리 초과...

        for (int i=0; i<=V; i++) {
            if (i == startVertex) {
                weightArray[i] = 0;
            } else {
                weightArray[i] = 1000000;
            }

            nodeList[i] = new ArrayList<>();
        }

        for (int i=1; i<=E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int tempStart = stoi(st2.nextToken());
            int tempEnd = stoi(st2.nextToken());
            int tempWeight = stoi(st2.nextToken());
            nodeList[tempStart].add(new Node(tempEnd, tempWeight));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int nowVertex = queue.poll();
            isVisited[nowVertex] = true;

            for (int i=0; i<nodeList[nowVertex].size(); i++) {
                Node nowNode = nodeList[nowVertex].get(i);
                if (weightArray[nowVertex] + nowNode.weight <= weightArray[nowNode.end]) {
                    weightArray[nowNode.end] = weightArray[nowVertex] + nowNode.weight;
                }
            }

            int nextWeight = 1000000;
            int nextIdx = 0;
            for (int i=1; i<=V; i++) {
                if (weightArray[i] < 1000000 && weightArray[i] <= nextWeight && !isVisited[i]) {
                    nextWeight = weightArray[i];
                    nextIdx = i;
                }
            }
            if (nextIdx > 0) {
                queue.add(nextIdx);
            }
        }

        for (int i=1; i<=V; i++) {
            if (i == startVertex) {
                System.out.println(0);
            } else if (weightArray[i] == 1000000) {
                System.out.println("INF");
            } else {
                System.out.println(weightArray[i]);
            }
        }
    }
}
