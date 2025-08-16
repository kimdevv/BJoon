import java.io.*;
import java.util.*;

public class BuildingRestAreas_1477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 휴게소의 개수
        int n = Integer.parseInt(st.nextToken());
        // 더 지으려고 하는 휴게소의 개수
        int m = Integer.parseInt(st.nextToken());
        // 고속도로의 길이
        int l = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(l % (m +1) == 0 ? l / (m +1) : l / (m +1) + 1);
            return;
        }

        int[] rests = new int[n + 2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i< n; i++) {
            rests[i] = Integer.parseInt(st.nextToken());
        }
        rests[n] = l;
        Arrays.sort(rests);

        int left = rests[0];
        int right = rests[n +1];
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                left ++;
                continue;
            }
            int count = 0;
            for (int i=0; i< n +1; i++) {
                count += calculateCountsInGap(mid, rests[i], rests[i+1]);
            }
            if (count > m) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static int calculateCountsInGap(int target, int min, int max) {
        int gap = max - min;
        return gap % target == 0 ? gap / target - 1 : gap / target;
    }
}