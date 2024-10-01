import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AlgoSpot_1261 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static class Node implements Comparable<Node> {
        int x; // 가로
        int y; // 세로
        int brokenCount;

        Node(int x, int y, int brokenCount) {
            this.x = x;
            this.y = y;
            this.brokenCount = brokenCount;
        }

        @Override
        public int compareTo(Node other) {
            return this.brokenCount - other.brokenCount;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken()); // 가로
        int N = stoi(st.nextToken()); // 세로

        // 벽 정보 초기화
        int[][] array = new int[N+1][M+1];
        for (int i=1; i<=N; i++) {
            String temp = br.readLine();
            for (int j=1; j<=M; j++) {
                array[i][j] = temp.charAt(j-1) - '0';
            }
        }

        // 방문한 곳인지 저장
        boolean[][] isVisited = new boolean[N+1][M+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 1, 0));
        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            int nowBrokenCount = nowNode.brokenCount;

            if (!isVisited[nowY][nowX]) {
                // 방문한 곳이 아니라면 방문했다고 알림
                isVisited[nowY][nowX] = true;
            } else {
                // 방문한 곳인 경우
                if (nowBrokenCount >= array[nowY][nowX]) {
                    // 현재 벽 부순 횟수보다 저장할 벽 부순 횟수가 더 크다면 continue
                    continue;
                }
            }

            // 벽 부순 횟수 저장
            array[nowY][nowX] = nowBrokenCount;

            for (int i=0; i<4; i++) {
                int cx = nowX + dx[i];
                int cy = nowY + dy[i];

                if ((1<=cx && cx<=M) && (1<=cy && cy<=N)) {
                    // 방문한 곳인데 그 곳으로 갈 때 벽 부순 횟수가 더 많아진다면 PQ에 넣지 않음
                    if (isVisited[cy][cx] && array[cy][cx] < nowBrokenCount+array[cy][cx]) {
                        continue;
                    }
                    pq.add(new Node(cx, cy, nowBrokenCount+array[cy][cx]));
                }
            }
        }

        System.out.println(array[N][M]);
    }
}