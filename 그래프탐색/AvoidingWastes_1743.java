import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AvoidingWastes_1743 {
    private static BufferedReader bufferedReader;
    private static int N; // 통로의 세로 길이
    private static int M; // 통로의 가로 길이
    private static int K; // 음식물 쓰레기의 개수
    private static boolean[][] wastes;
    private static boolean[][] isVisited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputNMK();
        inputWastes();
        traverse();
        bufferedReader.close();
    }

    private static void inputNMK() throws IOException {
        StringTokenizer NMK = new StringTokenizer(bufferedReader.readLine(), " ");
        N = Integer.valueOf(NMK.nextToken());
        M = Integer.valueOf(NMK.nextToken());
        K = Integer.valueOf(NMK.nextToken());
    }

    private static void inputWastes() throws IOException {
        wastes = new boolean[N+1][M+1];
        for (int i=0; i<K; i++) {
            StringTokenizer rawWaste = new StringTokenizer(bufferedReader.readLine(), " ");
            int r = Integer.valueOf(rawWaste.nextToken()); // 음쓰의 세로 좌표
            int c = Integer.valueOf(rawWaste.nextToken()); // 음쓰의 가로 좌표
            wastes[r][c] = true;
        }
    }

    private static void traverse() {
        isVisited = new boolean[N+1][M+1];
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (wastes[i][j] && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    max = Math.max(max, bfs(new Point(j, i)));
                }
            }
        }
        System.out.println(max);
    }

    private static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        int result = 1;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i=0; i<4; i++) {
                int cx = current.x + dx[i];
                int cy = current.y + dy[i];
                if ((1 <= cx && cx <= M) && (1 <= cy && cy <= N)) {
                    if (wastes[cy][cx] && !isVisited[cy][cx]) {
                        queue.add(new Point(cx, cy));
                        result++;
                        isVisited[cy][cx] = true;
                    }
                }
            }
        }
        return result;
    }
}