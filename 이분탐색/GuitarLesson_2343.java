import java.io.*;
import java.util.*;

public class GuitarLesson_2343 {

    private static int N; // 강의의 수
    private static int M; // 블루레이의 수
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        array = new int[N];
        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());

        br.close();
    }

    private static long binarySearch() {
        long left = 0;
        long right = 20_000_000_000L;

        long minLength = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            long currentCount = count(mid);
            if (currentCount > M) {
                left = mid + 1;
            } else { // M개 이하로 담을 수 있으면 정답의 후보가 됨
                minLength = mid;
                right = mid - 1;
            }
        }
        return minLength;
    }

    private static long count(long max) {
        long count = 1;
        long sum = 0;
        for (int i=N-1; i>=0; i--) {
            if (array[i] > max) { // 만들려는 강의의 길이가 하나의 강의를 못 담는 경우는 불가능함
                return 20_000_000_000L;
            }
            if (sum + array[i] > max) {
                count++;
                sum = 0;
            }
            sum += array[i];
        }
        return count;
    }
}
