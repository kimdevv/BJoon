import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeQuest {
    static int N;
    static int M;
    static int[][] array;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); // y의 최댓값
        M = stoi(st.nextToken()); // x의 최댓값

        array = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                array[i][j] = line.charAt(j) - '0'; // 0 또는 1
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (array[i][j]==1 && !isVisited[i][j]) {
                    Point point = new Point(j, i); // j가 x고 i가 y임
                    dfs(point);
                }
            }
        }
    }

    public static void dfs(Point point) {
        if (point.x==M-1 && point.y==N-1) {
            System.out.println(count);
        }

        isVisited[point.y][point.x] = true;

        int tmpCount = 0;
        for (int i=0; i<4; i++) {
            int cx = point.x + dx[i];
            int cy = point.y + dy[i];

            //System.out.println(cx + " " + cy);
            if ((0<=cx && cx<M) && (0<=cy && cy<N)){
                if (array[cy][cx]==1 && !isVisited[cy][cx]) {
                    tmpCount++;
                    dfs(new Point(cx, cy));
                }
            }
        }
        count += tmpCount;
    }
}
