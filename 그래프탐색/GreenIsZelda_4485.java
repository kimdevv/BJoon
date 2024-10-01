import java.io.*;
import java.util.*;
import java.util.PriorityQueue;

public class GreenIsZelda_4485 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int rupee;

        Node(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Node other) { // Comparable 상속 후 비교 연산 오버라이드
            return this.rupee - other.rupee;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int problemCount = 0;
        while (++problemCount > 0) {
            int N = stoi(br.readLine());
            if (N == 0) { // N이 0이면 종료
                break;
            }

            // 각 맵(?) 별로 루피 수를 저장
            int[][] rupeeArray = new int[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    rupeeArray[i][j] = stoi(st.nextToken());
                }
            }

            // 맵을 돌면서 총 잃는 루피 수를 저장
            int[][] saveRupee = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(saveRupee[i], 100000);
            }
            saveRupee[0][0] = rupeeArray[0][0];

            // 우선순위 큐
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, rupeeArray[0][0]));

            while (!pq.isEmpty()) {
                Node nowNode = pq.poll();
                int nowX = nowNode.x;
                int nowY = nowNode.y;
                int nowRupee = nowNode.rupee;

                // 상하좌우를 이동하면서
                for (int i=0; i<4; i++) {
                    int cx = nowX + dx[i];
                    int cy = nowY + dy[i];

                    if ((0 <= cx && cx < N) && (0 <= cy && cy < N)) {
                        int nextRupee = nowRupee + rupeeArray[cy][cx];

                        // 다음에 잃는 루피가 현재 저장된 루피 수보다 더 적다면 그걸로 변경 후 PQ에 넣음(그 맵으로 이동)
                        // PQ에 넣는 노드 수에 따라 메모리 초과 여부가 결정된다 -> 이 조건문을 while문 밖으로 빼내면 메모리 초과 (PQ에 모든 노드가 일단 저장되므로)
                        if (nextRupee < saveRupee[cy][cx]) {
                            saveRupee[cy][cx] = nextRupee;
                            Node nextNode = new Node(cx, cy, nextRupee);
                            pq.add(nextNode);
                        }
                    }
                }
            }

            System.out.println("Problem " + problemCount + ": " + saveRupee[N-1][N-1]);
        }
    }
}