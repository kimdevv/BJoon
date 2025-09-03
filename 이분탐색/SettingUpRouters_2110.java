import java.io.*;
import java.util.*;

public class SettingUpRouters_2110 {

    private static PriorityQueue<Integer> houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 집의 개수
        int n = Integer.parseInt(st.nextToken());
        // 공유기의 개수
        int c = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        houses = new PriorityQueue<>();
        for (int i=0; i< n; i++) {
            int number = Integer.parseInt(br.readLine());
            right = Math.max(right, number);
            houses.offer(number);
        }

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = countRoutersBetween(mid);
            if (count > c) {
                result = mid;
                left = mid + 1;
            } else if (count < c) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static int countRoutersBetween(int gap) {
        int count = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(houses);
        int now = pq.poll();
        while (!pq.isEmpty()) {
            int next = pq.poll();
            if (next - now >= gap) {
                count++;
                now = next;
            }
        }

        return count;
    }
}
