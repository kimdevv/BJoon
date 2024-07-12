import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage {
    static int M; // 밭의 가로 길이
    static int N; // 밭의 세로 길이
    static int K; // 배추의 개수
    static int[][] array; // 밭
    static boolean[][] isVisited;
    static Queue<Point> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());
        for(int i=0; i<T; i++) {
            queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = stoi(st.nextToken());
            N = stoi(st.nextToken());
            array = new int[M][N];
            isVisited = new boolean[M][N];

            K = stoi(st.nextToken());
            for (int j=0; j<K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int num1 = stoi(st2.nextToken());
                int num2 = stoi(st2.nextToken());
                array[num1][num2] = 1;
            }

            int count = 0;
            for (int j=0; j<M; j++) {
                for (int k=0; k<N; k++) {
                    if (array[j][k] == 1 && !isVisited[j][k]) {
                        bfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int j, int k) {
        isVisited[j][k] = true;
        queue.add(new Point(j, k));

        while (!queue.isEmpty()) {
            Point vertex = queue.poll();

            for (int i=0; i<4; i++) {
                int cx = vertex.x + dx[i];
                int cy = vertex.y + dy[i];

                if ((0 <= cx && cx < M) && (0 <= cy && cy < N)) {
                    if (array[cx][cy] == 1 && !isVisited[cx][cy]) {
                        isVisited[cx][cy] = true;
                        queue.add(new Point(cx, cy));
                    }
                }
            }
        }
    }

    /*public static void bfs(int j, int k) {
        isVisited[j][k] = true;
        queue.add(new Point(j, k));

        while (!queue.isEmpty()) {
            Point vertex = queue.poll();
            int x = vertex.x;
            int y = vertex.y;
            if ((x-1) >=0 && array[x-1][y] == 1 && !isVisited[x-1][y]) {
                isVisited[x-1][y] = true;
                queue.add(new Point(x-1, y));
            }
            if ((x+1) <M && array[x+1][y] == 1 && !isVisited[x+1][y]) {
                isVisited[x+1][y] = true;
                queue.add(new Point(x+1, y));
            }
            if ((y-1) >=0 && array[x][y-1] == 1 && !isVisited[x][y-1]) {
                isVisited[x][y-1] = true;
                queue.add(new Point(x, y-1));
            }
            if ((y+1) <N && array[x][y+1] == 1 && !isVisited[x][y+1]) {
                isVisited[x][y+1] = true;
                queue.add(new Point(x, y+1));
            }
        }
    }*/
}
