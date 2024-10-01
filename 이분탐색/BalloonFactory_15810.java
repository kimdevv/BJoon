import java.io.*;
import java.util.*;

public class BalloonFactory_15810 {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = stoi(stringTokenizer.nextToken()); // 스태프의 수
        int M = stoi(stringTokenizer.nextToken()); // 풍선의 수

        // 스태프들이 풍선 하나 만드는 데 걸리는 시간 입력받은 후 정렬
        int[] array = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N; i++) {
            array[i] = stoi(stringTokenizer.nextToken());
        }
        Arrays.sort(array);

        // 이분 탐색
        long result = binarySearch(array, M, 0, (long)M*1_000_000L); // 걸리는 시간은 최대 1_000_000 * 1_000_000초까지 가능하므로 long으로 한다.
        System.out.println(result);
    }

    public static long binarySearch(int[] array, int balloonCount, long left, long right) {
        long result = 0;

        while (left <= right) {
            long mid = (left+right) / 2; // 걸리는 시간 (매개변수)

            long count = 0; // mid 시간 안에 각 스태프들이 만들 수 있는 풍선 개수의 합
            for(int i=0; i<array.length; i++) {
                count += mid / array[i];
            }

            if (count >= balloonCount) { // count를 줄여줘야 함 -> right 감소
                result = mid;
                right = mid - 1;
            } else { // count를 늘려줘야 함 -> left 증가
                left = mid + 1;
            }
        }
        return result;
    }
}