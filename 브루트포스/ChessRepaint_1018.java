import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessRepaint_1018 {

    static char[][] chess;

    public static int stoi(String st) {
        return Integer.parseInt(st);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        chess = new char[N][M];

        // 체스판을 채운다.
        for (int i=0; i<N; i++) {
            String line =br.readLine();
            for (int j=0; j<M; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        // 기준점에서 아래로 +8, 오른쪽으로 +8 이동해야 하므로 가능한 영역만 선택.
        int min = Integer.MAX_VALUE;
        for (int i=0; i<N-7; i++) {
            for (int j=0; j<M-7; j++) {
                int count = blackOrwhite(i, j);
                min = Math.min(min, count);
            }
        }

        System.out.println(min);
    }


    public static int blackOrwhite(int x, int y) {

        // 첫 번째 수(기준점)가 B라고 가정하는 경우
        int countB = 0;
        for (int i=x; i<x+8; i++) {
            for (int j=y; j<y+8; j++) {
                if (i%2 == 0) { // 홀수 번 째 x (맨 앞자리가 B)
                    if (j%2 == 0) {
                        if (chess[i][j] == 'W') {
                            countB++;
                        }
                    } else {
                        if (chess[i][j] == 'B') {
                            countB++;
                        }
                    }
                } else { // 짝수 번 째 y (맨 앞자리가 W)
                    if (j%2 == 0) {
                        if (chess[i][j] == 'B') {
                            countB++;
                        }
                    } else {
                        if (chess[i][j] == 'W') {
                            countB++;
                        }
                    }
                }
            }
        }

        // 첫 번째 수(기준점)가 W라고 가정하는 경우
        int countW = 0;
        for (int i=x; i<x+8; i++) {
            for (int j=y; j<y+8; j++) {
                if (i%2 == 0) { // 홀수 번 째 x (맨 앞자리가 W)
                    if (j%2 == 0) {
                        if (chess[i][j] == 'B') {
                            countW++;
                        }
                    } else {
                        if (chess[i][j] == 'W') {
                            countW++;
                        }
                    }
                } else { // 짝수 번째 y (맨 앞자리가 B)
                    if (j%2 == 0) {
                        if (chess[i][j] == 'W') {
                            countW++;
                        }
                    } else {
                        if (chess[i][j] == 'B') {
                            countW++;
                        }
                    }
                }
            }
        }

        return Math.min(countB, countW);
    }
}
