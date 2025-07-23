import java.io.*;
import java.util.*;

public class WantSpecialAward_24460 {

    private static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(divideAndConquer(0, 0, N));
        br.close();
    }

    private static int divideAndConquer(int startX, int startY, int length) {
        if (length == 1) {
            return array[startY][startX];
        }

        int halfLength = length / 2;
        List<Integer> result = new ArrayList<>();
        result.add(divideAndConquer(startX, startY, halfLength));
        result.add(divideAndConquer(startX + halfLength, startY, halfLength));
        result.add(divideAndConquer(startX, startY + halfLength, halfLength));
        result.add(divideAndConquer(startX + halfLength, startY + halfLength, halfLength));
        Collections.sort(result);
        return result.get(1);
    }
}