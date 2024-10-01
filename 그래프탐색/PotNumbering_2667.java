import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PotNumbering_2667 {
    static int N;
    static int[][] array;
    static Queue<twoNumber> queue = new LinkedList<>();
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> result = new ArrayList<>();

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        array = new int[N+1][N+1];
        isVisited = new boolean[N+1][N+1];
        for (int i=1; i<=N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                array[i][j+1] = line.charAt(j) - '0';
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (array[i][j] == 1 && !isVisited[i][j]) {
                    bfs(new twoNumber(i, j));
                }
            }
        }

        Collections.sort(result);

        int resultSize = result.size();
        System.out.println(resultSize);
        for (int i=0; i<resultSize; i++) {
            System.out.println(result.get(i));
        }
    }

    public static void bfs (twoNumber start) {
        isVisited[start.y][start.x] = true;
        queue.add(start);

        int count = 1;
        while (!queue.isEmpty()) {
            twoNumber numbers = queue.poll();
            int y = numbers.y;
            int x = numbers.x;
            
            for (int i=0; i<4; i++) {
                int cy = y + dy[i];
                int cx = x + dx[i];
                if ((1<=cx && cx<=N) && (1<=cy && cy <= N)) {
                    if (array[cy][cx] == 1 && !isVisited[cy][cx]) {
                        count++;
                        isVisited[cy][cx] = true;
                        queue.add(new twoNumber(cy, cx));
                    }
                }
            }
        }
        result.add(count);
    }
    public static class twoNumber {
        int y;
        int x;

        twoNumber(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

