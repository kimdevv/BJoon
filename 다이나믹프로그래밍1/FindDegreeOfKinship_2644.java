import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class FindDegreeOfKinship_2644 {

    private static int n; // 전체 사람의 수
    private static int person1, person2; // 촌수를 계산해야 하는 두 사람
    private static ArrayList[] graph;
    private static int[] degreeOfKinshipOfPerson1;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        intputPerson();
        inputGraph();
        dfs(person1, 0);
        outputResult();
    }

    private static void intputPerson() throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());
    }

    private static void inputGraph() throws IOException {
        graph = new ArrayList[n+1];
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        degreeOfKinshipOfPerson1 = new int[n+1];
        Arrays.fill(degreeOfKinshipOfPerson1, Integer.MAX_VALUE);
        degreeOfKinshipOfPerson1[person1] = 0;

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i< m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }
    }

    private static void dfs(int node, int degree) {
        for (int i=0; i<graph[node].size(); i++) {
            int nextNode = (int) graph[node].get(i);
            if (degreeOfKinshipOfPerson1[nextNode] == Integer.MAX_VALUE) {
                degreeOfKinshipOfPerson1[nextNode] = degree + 1;
                dfs(nextNode, degreeOfKinshipOfPerson1[nextNode]);
            }
        }
    }

    private static void outputResult() throws IOException {
        System.out.println(degreeOfKinshipOfPerson1[person2] == Integer.MAX_VALUE ? -1 : degreeOfKinshipOfPerson1[person2]);
        br.close();
    }
}