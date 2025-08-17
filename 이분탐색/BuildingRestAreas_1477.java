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

        int[] rests = new int[n + 2]; // N개 + 0 + 끝
        if (n != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i=0; i< n; i++) {
                rests[i] = Integer.parseInt(st.nextToken());
            }
        }
        rests[n] = l;
        Arrays.sort(rests);

        int left = rests[0]; // 도로의 가장 처음으로 초기화
        int right = rests[n +1]; // 도로의 가장 끝으로 초기화
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
            } else { // M개 이하로 휴게소를 세울 수 있으면 나머지 개수는 아무데나 세우면 된다
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