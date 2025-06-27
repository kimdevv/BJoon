import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class FindParentOfTree_11725 {

    private static ArrayList[] graph;
    private static int[] parents;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        inputN();
        inputNode();
        dfs(1);
        outputResult();
    }

    private static void inputN() throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n +1];
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        parents = new int[n +1];
        Arrays.fill(parents, Integer.MAX_VALUE);
        parents[1] = 0;
    }

    private static void inputNode() throws IOException {
        String line = br.readLine();
        while(line != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            graph[number1].add(number2);
            graph[number2].add(number1);
            line = br.readLine();
        }
        br.close();
    }

    private static void dfs(int node) {
        for (int i=0; i<graph[node].size(); i++) {
            int nextNode = (int) graph[node].get(i);
            if (parents[nextNode] == Integer.MAX_VALUE) {
                parents[nextNode] = node;
                dfs(nextNode);
            }
        }
    }

    private static void outputResult() {
        for (int i=2; i<parents.length; i++) {
            System.out.println(parents[i]);
        }
    }
}