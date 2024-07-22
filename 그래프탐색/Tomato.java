import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    static int M;
    static int N;
    static int[][] array;
    static Queue<twoNumber> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    private static class twoNumber {
        int x;
        int y;
        twoNumber(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        array = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                int tmp = stoi(st2.nextToken());
                array[i][j] = tmp;

                if (tmp == 1) {
                    queue.add(new twoNumber(j, i));
                }
            }
        }

        goRipe();

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (array[i][j] == 0) {
                    max = -1;
                }
            }
        }
        System.out.println(max>0 ? max-1 : max);
    }

    public static void goRipe() {
        while (!queue.isEmpty()) {

            twoNumber start = queue.poll();

            for (int i=0; i<4; i++) {
                int cx = start.x + dx[i];
                int cy = start.y + dy[i];

                if ((1<=cx && cx<=M) && (1<=cy && cy<=N)) {
                    if (array[cy][cx]==0) {
                        int nextCount = array[start.y][start.x]+1;
                        queue.add(new twoNumber(cx, cy));
                        array[cy][cx] = nextCount;
                        if (nextCount > max) {
                            max = nextCount;
                        }
                    }
                }
            }
        }
    }
}