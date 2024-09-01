import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet {
    static int R; // 세로
    static int C; // 가로
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] array;
    static int count = 0;

    public static int stoi(String st) {
        return Integer.parseInt(st);
    }

    public static class Node {
        int x;
        int y;
        int count;
        String visitedAlphabet;

        Node(int x, int y, int count, String visitedAlphabet) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.visitedAlphabet = visitedAlphabet;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        array = new char[R+1][C+1];

        for (int i=1; i<=R; i++) {
            String temp = br.readLine();
            for (int j=1; j<=C; j++) {
                array[i][j] = temp.charAt(j-1);
            }
        }

        Node start = new Node(1, 1, 1, "");
        dfs(start);

        System.out.println(count);
    }

    public static void dfs(Node start) {
        int nowX = start.x;
        int nowY = start.y;
        String nowVisitedAlphabet = start.visitedAlphabet;

        if (count < start.count) { count = start.count; }
        nowVisitedAlphabet += array[nowY][nowX];

        for (int i=0; i<4; i++) {
            int cx = nowX + dx[i];
            int cy = nowY + dy[i];

            if ((1<=cx && cx <= C) && (1<=cy && cy<= R)) {
                if (!nowVisitedAlphabet.contains(String.valueOf(array[cy][cx]))) {
                    Node next = new Node(cx, cy, start.count+1, nowVisitedAlphabet);
                    dfs(next);
                }
            }
        }
    }
}
