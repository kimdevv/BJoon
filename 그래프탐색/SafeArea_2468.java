import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeArea_2468 {

    private static int N;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int maxHeight = Integer.MIN_VALUE;
        int[][] locations = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, height);
                locations[i][j] = height;
            }
        }

        int result = -1;
        while (maxHeight-- >= 0) {
            int count = 0;
            boolean[][] isVisited = new boolean[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (locations[i][j] > maxHeight && !isVisited[i][j]) {
                        count++;
                        dfs(i, j, locations, isVisited, maxHeight);
                    }
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
        br.close();
    }

    private static void dfs(int y, int x, int[][] locations, boolean[][] isVisited, int maxHeight) {
        isVisited[y][x] = true;
        for (int i=0; i<4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if ((0 <= nextX && nextX < N) && (0 <= nextY && nextY < N)) {
                if (locations[nextY][nextX] > maxHeight && !isVisited[nextY][nextX]) {
                    dfs(nextY, nextX, locations, isVisited, maxHeight);
                }
            }
        }
    }
}