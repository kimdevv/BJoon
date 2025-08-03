import java.io.*;
import java.util.*;

public class ArrayPower_10830 {

    private static int N;
    private static final int MOD = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 행렬의 크기
        long B = Long.parseLong(st.nextToken()); // 제곱 수

        int[][] numbers = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=N; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = divideAndConquer(numbers, B);
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                System.out.print((result[i][j] % MOD) + " ");
            }
            System.out.println();
        }

        br.close();
    }

    private static int[][] divideAndConquer(int[][] array, long power) {
        if (power == 1) {
            return array;
        }

        int[][] halfPowered = divideAndConquer(array, power / 2);
        int[][] result = power(halfPowered, halfPowered);

        if (power % 2 == 1) {
            result = power(result, array);
        }

        return result;
    }

    private static int[][] power(int[][] array1, int[][] array2) {
        int[][] result = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                for (int k=1; k<=N; k++) {
                    result[i][j] += (array1[i][k] * array2[k][j]) % MOD;
                }
            }
        }
        return result;
    }
}
