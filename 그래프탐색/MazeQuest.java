import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeQuest {
    static int N;
    static int M;
    static int[][] array;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // y의 최댓값
        M = stoi(st.nextToken()); // x의 최댓값

        array = new int[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                array[i][j] = line.charAt(j) - '0'; // 0 또는 1
            }
        }
        System.out.println(array.toString());
        Point point = new Point(0, 0);
        dfs(point, 1, new boolean[N][M]);
        System.out.println(result);
    }

    public static void dfs(Point point, int count, boolean[][] isVisited) {
        System.out.println("[" + point.y + "] [" + point.x + "] " + count);
        if (point.x==M-1 && point.y==N-1) {
            if (count < result) {
                result = count;
            }
        } else {
            boolean[][] nextVisited = isVisited.clone();
            nextVisited[point.y][point.x] = true;

            for (int i=0; i<4; i++) {
                int cx = point.x + dx[i];
                int cy = point.y + dy[i];

                if ((0<=cx && cx<M) && (0<=cy && cy<N)){
                    if (array[cy][cx]==1 && !isVisited[cy][cx]) {
                        System.out.println(point.y + " " + point.x);
                        dfs(new Point(cx, cy), count+1, nextVisited);
                    }
                }
            }
        }
    }
}
