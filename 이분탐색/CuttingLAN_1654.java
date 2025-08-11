import java.io.*;
import java.util.*;

public class CuttingLAN_1654 {

    private static int K; // 현재 갖고 있는 랜선 개수
    private static int N; // 만들려는 랜선 개수
    private static int[] cables;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cables = new int[K];
        long sum = 0;
        for (int i=0; i<K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            sum += cables[i];
        }

        System.out.println(findTreshold(sum));
    }

    private static long findTreshold(long limit) {
        long left = 1;
        long right = (long)Integer.MAX_VALUE * K;

        long maxLength = 1;
        while (left <= right) {
            long mid = (left + right) / 2;

            long cableCount = calculateCount(mid);
            if (cableCount < N || limit < mid) {
                right = mid - 1;
            } else {
                maxLength = mid;
                left = mid + 1;
            }
        }
        return maxLength;
    }

    private static long calculateCount(long length) {
        long result = 0;
        for (long cable : cables) {
            result += (cable / length);
        }
        return result;
    }
}
