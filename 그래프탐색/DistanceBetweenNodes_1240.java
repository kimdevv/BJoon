import java.io.*;
import java.util.*;

public class DistanceBetweenNodes_1240 {
  private static BufferedReader bufferedReader;
  private static int N; // 노드의 개수
  private static int M; // 길이를 알고 싶은 노드 쌍의 개수
  private static List<Node>[] tree;
  private static int[][] distances;
  
  public static void main(String[] args) throws IOException {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    inputNM();
    inputTree();
    calculateDistances();
    bufferedReader.close();
  }
  
  private static void inputNM() throws IOException {
    StringTokenizer NM = new StringTokenizer(bufferedReader.readLine(), " ");
    N = Integer.valueOf(NM.nextToken());
    M = Integer.valueOf(NM.nextToken());
  }
  
  private static void inputTree() throws IOException {
    tree = new ArrayList[N+1];
    for (int i=0; i<=N; i++) {
      tree[i] = new ArrayList<>();
    }
    
    for (int i=0; i<N-1; i++) {
      StringTokenizer rawNode = new StringTokenizer(bufferedReader.readLine(), " ");
      int firstIndex = Integer.valueOf(rawNode.nextToken());
      int secondIndex = Integer.valueOf(rawNode.nextToken());
      int distance = Integer.valueOf(rawNode.nextToken());
      tree[firstIndex].add(new Node(secondIndex, distance));
      tree[secondIndex].add(new Node(firstIndex, distance));
    }
  }
  
  private static void calculateDistances() throws IOException {
    distances = new int[N+1][N+1];
    for (int i=0; i<M; i++) {
      StringTokenizer rawInput = new StringTokenizer(bufferedReader.readLine(), " ");
      int start = Integer.valueOf(rawInput.nextToken());
      int end = Integer.valueOf(rawInput.nextToken());
      traverse(start, end);
      System.out.println(distances[start][end]);
    }
  }
  
  private static void traverse(int start, int end) {
    Arrays.fill(distances[start], Integer.MAX_VALUE);
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(start, 0));
    distances[start][start] = 0;
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      for (Node next : tree[current.end]) {
        if (distances[start][next.end] >= distances[start][current.end] + next.distance) {
          distances[start][next.end] = distances[start][current.end] + next.distance;
          queue.add(new Node(next.end, next.distance));
        }
      }
    }
  }
  
  private static class Node implements Comparable<Node> {
    private int end;
    private int distance;
    
    private Node(int end, int distance) {
      this.end = end;
      this.distance = distance;
    }
    
    public int compareTo(Node other) {
      return this.distance - other.distance;
    }
  }
}
