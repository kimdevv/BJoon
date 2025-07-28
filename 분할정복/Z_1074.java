import java.io.*;
import java.util.*;

public class Z_1074 {

    private static int r; // 행
    private static int c; // 열
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        divideAndConquer(0, 0, (int)Math.pow(2, N));

        br.close();
    }

    private static void divideAndConquer(int x, int y, int length) {
        if (x == c && y == r) {
            System.out.println(count);
            return;
        }
        int halfLength = length / 2;
        int nextX = x + halfLength;
        int nextY = y + halfLength;
        if (c < nextX) { // (c, r)이 포함된 사분면만 재귀 호출
            if (r < nextY) {
                divideAndConquer(x, y, halfLength);
            } else {
                count += (Math.pow(halfLength, 2) * 2);
                divideAndConquer(x, nextY, halfLength);
            }
        } else {
            if (r < nextY) {
                count += Math.pow(halfLength, 2);
                divideAndConquer(nextX, y, halfLength);
            } else {
                count += (Math.pow(halfLength, 2) * 3);
                divideAndConquer(nextX, nextY, halfLength);
            }
        }
    }
}
