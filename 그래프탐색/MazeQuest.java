import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeQuest {
    static int N;
    static int M;
    static int[][] array;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // y의 최댓값
        M = stoi(st.nextToken()); // x의 최댓값
        array = new int[N+1][M+1];
        isVisited = new boolean[N+1][M+1];

        // 배열 초기화
        for (int i=1; i<=N; i++) {
            String line = br.readLine();
            for (int j=1; j<=M; j++) {
                array[i][j] = line.charAt(j-1) - '0';
            }
        }

        // (1, 1)부터 방문 후 bfs로 탐색
        isVisited[1][1] = true;
        bfs(new Node(1, 1));

        System.out.println(array[N][M]);
    }

    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i=0; i<4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if ((1<=cx&&cx<=M) && (1<=cy&&cy<=N)) {
                    if (array[cy][cx] != 0 && !isVisited[cy][cx]) {
                        isVisited[cy][cx] = true;
                        array[cy][cx] = array[y][x]+1;
                        queue.add(new Node(cx, cy));
                    }
                }
            }
        }
    }
}
