import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Tree_1068 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine()); // 노드의 개수
    
    List<Integer>[] tree = new ArrayList[N];
    for (int i=0; i<N; i++) {
      tree[i] = new ArrayList<>();
    }
    
    int root = -1;
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i=0; i<N; i++) {
      int parent = Integer.parseInt(st.nextToken());
      if (parent == -1) {
        root = i;
      } else {
        tree[parent].add(i);
      }
    }
    
    int delete = Integer.parseInt(br.readLine());
    
    int result = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    if (delete != root) {
      queue.offer(root);
    }
    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (tree[node].isEmpty() || (tree[node].size() == 1 && tree[node].get(0) == delete)) {
        result++;
        continue;
      }
      for (int next : tree[node]) {
        if (next != delete) {
          queue.offer(next);
        }
      }
    }
    
    System.out.println(result);
    br.close();
  }
}
