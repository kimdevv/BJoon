import java.awt.Point;
import java.io.*;
import java.util.*;
import java.util.Queue;

public class SeniorNeedsFriends_21736 {

    private static int N; // 캠퍼스의 세로 길이
    private static int M; // 캠퍼스의 가로 길이

    private static boolean[][] graph;
    private static boolean[][] isFriend;
    private static boolean[][] isVisited;
    private static Point start;
    private static int count;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();
        bfs(start);
        outputResult();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][M+1];
        isFriend = new boolean[N+1][M+1];
        isVisited = new boolean[N+1][M+1];
        for (int i=1; i<graph.length; i++) {
            String line = br.readLine();
            for (int j=1; j<graph[i].length; j++) {
                char info = line.charAt(j - 1);
                if (info == 'P') {
                    graph[i][j] = true;
                    isFriend[i][j] = true;
                } else if (info == 'O') {
                    graph[i][j] = true;
                } else if (info == 'I') {
                    isVisited[i][j] = true;
                    start = new Point(j, i);
                }
            }
        }

        br.close();
    }

    private static void bfs(Point start) {
        int startX = start.x;
        int startY = start.y;
        isVisited[startY][startX] = true;

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            for (int i=0; i<4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if ((0 <= nextX && nextX <= M) && (0 <= nextY && nextY <= N)) {
                    if (graph[nextY][nextX] && !isVisited[nextY][nextX]) {
                        isVisited[nextY][nextX] = true;
                        queue.add(new Point(nextX, nextY));
                        if (isFriend[nextY][nextX]) {
                            count++;
                        }
                    }
                }
            }
        }
    }

    private static void outputResult() {
        System.out.println(count == 0 ? "TT": count);
    }
}