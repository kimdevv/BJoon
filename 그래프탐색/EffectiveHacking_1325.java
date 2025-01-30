import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class EffectiveHacking_1325 {
    private static int N; // 컴퓨터 개수
    private static int M; // 신뢰하는 관계의 개수
    private static List<ArrayList<Integer>> trustRelationships; // 신뢰 관계 리스트
    private static int[] availableHackingCount;
    private static boolean[] visited;
    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        initializeBufferedReader();
        inputNM();
        intputTrustRelationship();
        processGraph();
        outputResult();
    }

    private static void initializeBufferedReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void inputNM() throws IOException {
        StringTokenizer NM = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());
    }

    private static void intputTrustRelationship() throws IOException {
        trustRelationships = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<N+1; i++) {
            trustRelationships.add(new ArrayList<Integer>());
        }

        StringTokenizer rawRelationship;
        for (int i=0; i<M; i++) {
            rawRelationship = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(rawRelationship.nextToken());
            int end = Integer.parseInt(rawRelationship.nextToken());
            trustRelationships.get(start).add(end);
        }
    }

    private static void processGraph() {
        availableHackingCount = new int[N+1];
        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }
    }

    private static void bfs(int index) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : trustRelationships.get(now)) {
                if (!visited[next]) {
                    queue.add(next);
                    availableHackingCount[next]++;
                    visited[next] = true;
                }
            }
        }
    }

    private static void outputResult() {
        int max = Arrays.stream(availableHackingCount)
                .max()
                .getAsInt();
        StringBuilder result = new StringBuilder();
        for (int i=1; i<=N; i++) {
            if (availableHackingCount[i] == max) {
                result.append(i + " ");
            }
        }
        System.out.println(result);
    }
}