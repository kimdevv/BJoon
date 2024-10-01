import java.io.*;
import java.util.*;
import java.util.Queue;

public class RedGreenColorBlindness_10026 {
    static int N;
    static int[][] array;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<twoNumber> queue = new LinkedList<>();

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    private static class twoNumber {
        int x;
        int y;
        twoNumber(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        array = new int[N+1][N+1];
        isVisited = new boolean[N+1][N+1];

        for (int i=1; i<=N; i++) {
            String temp = br.readLine();
            for (int j=1; j<=N; j++) {
                array[i][j] = temp.charAt(j-1);
            }
        }

        int result = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (!isVisited[i][j]) {
                    result ++;
                    bfs(new twoNumber(j, i), array[i][j]);
                }
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (array[i][j] == 'G'){
                    array[i][j] = 'R';
                }
            }
        }

        isVisited = new boolean[N+1][N+1];
        int result2 = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (!isVisited[i][j]) {
                    result2 ++;
                    bfs(new twoNumber(j, i), array[i][j]);
                }
            }
        }

        System.out.println(result + " " + result2);
    }

    public static void bfs(twoNumber start, int color) {
        isVisited[start.y][start.x] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            twoNumber now = queue.poll();
            int x = now.x;
            int y = now.y;

            for (int i=0; i<4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if ((1<=cx && cx<=N) && (1<=cy && cy<=N)) {
                    if (!isVisited[cy][cx] && array[cy][cx]==color) {
                        isVisited[cy][cx] = true;
                        queue.add(new twoNumber(cx, cy));
                    }
                }
            }
        }
    }
}