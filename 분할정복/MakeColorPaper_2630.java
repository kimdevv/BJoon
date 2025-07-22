import java.io.*;
import java.util.*;

public class MakeColorPaper_2630 {

    private static int[][] array;
    private static final int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 한 변의 길이
        array = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, N);
        for (int result : count) {
            System.out.println(result);
        }
    }

    private static void divideAndConquer(int startX, int startY, int length) {
        int startColor = array[startY][startX];
        for (int y=0; y<length; y++) {
            for (int x=0; x<length; x++) {
                if (array[startY + y][startX + x] != startColor) {
                    divideAndConquer(startX, startY, length / 2);
                    divideAndConquer(startX + (length / 2), startY, length / 2);
                    divideAndConquer(startX, startY + (length / 2), length / 2);
                    divideAndConquer(startX + (length / 2), startY + (length / 2), length / 2);
                    return;
                }
            }
        }
        count[startColor]++;
    }
}