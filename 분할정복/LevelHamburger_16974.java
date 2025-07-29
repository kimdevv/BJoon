import java.io.*;
import java.util.*;

public class LevelHamburger_16974 {

    private static final long[] patties = new long[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        saveFullPattyCount(50);
        long count = divideAndConquer(N, X);
        System.out.println(count);
        br.close();
    }

    private static void saveFullPattyCount(int level) {
        if (level == 1) {
            patties[level] = 3;
            return;
        }
        saveFullPattyCount(level - 1);
        patties[level] = patties[level - 1] * 2 + 1;
    }

    private static long divideAndConquer(int level, long targetBackIndex) {
        if (level == 1) {
            if (targetBackIndex == 1) {
                return 0;
            } else if (targetBackIndex == 2) {
                return 1;
            } else if (targetBackIndex == 3) {
                return 2;
            } else {
                return 3;
            }
        }

        long count = 0;
        long previousLength = getLength(level - 1);
        if (targetBackIndex == 1) { // 햄버거 번
            return count;
        } else if (targetBackIndex <= previousLength + 1) { // 첫 번째 이전 레벨 햄버거
            count += divideAndConquer(level - 1, targetBackIndex - 1);
            return count;
        } else if (targetBackIndex == previousLength + 2) { // 가운데 위치한 패티
            count += patties[level - 1];
            count += 1;
            return count;
        } else if (targetBackIndex <= previousLength * 2 + 2) { // 두 번째 이전 레벨 햄버거
            count += patties[level - 1];
            count += 1;
            count += divideAndConquer(level - 1, targetBackIndex - previousLength - 2);
            return count;
        } else { // 햄버거 번
            count += patties[level - 1] * 2;
            count += 1;
            return count;
        }
    }

    private static long getLength(int level) {
        if (level == 1) {
            return 5;
        }
        return getLength(level - 1) * 2 + 3;
    }
}
