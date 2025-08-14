import java.io.*;
import java.util.*;

public class RobotProject_3649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String next;
        first: while ((next = br.readLine()) != null) {
            // 구멍의 너비 (나노미터)
            long x = Integer.parseInt(next) * 10_000_000L;
            // 레고 조각의 수
            int n = Integer.parseInt(br.readLine());

            int[] legos = new int[n];
            for (int i=0; i< n; i++) {
                legos[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(legos);

            int leftIndex = 0;
            int rightIndex = legos.length - 1;
            while (leftIndex < rightIndex) {
                long sum = legos[leftIndex] + legos[rightIndex];
                if (sum > x) {
                    rightIndex = rightIndex - 1;
                } else if (sum < x) {
                    leftIndex = leftIndex + 1;
                } else {
                    System.out.printf("yes %d %d%n", legos[leftIndex], legos[rightIndex]);
                    continue first;
                }
            }
            System.out.printf("danger%n");
        }

        br.close();
    }
}
