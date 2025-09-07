import java.io.*;
import java.util.*;

public class SumIsZero_3151 {

    private static int N; // 학생의 수
    private static int[] students; // 학생들의 코딩 실력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        students = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(students);

        long result = 0;
        for (int i=0; i<N-2; i++) {
            int student = students[i];
            result += findZeroSum(-student, i+1);
        }

        System.out.println(result);
        br.close();
    }

    private static long findZeroSum(int target, int startIndex) {
        long result = 0;

        int left = startIndex;
        int right = N - 1;
        while (left < right) {
            int sum = students[left] + students[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                int upperBound = findUpperBoundOf(students[right], left+1);
                int lowerBound = findLowerBoundOf(students[right], left+1);
                result += (upperBound - lowerBound);
                left++;
            }
        }
        return result;
    }

    private static int findUpperBoundOf(int target, int left) {
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = students[mid];
            if (target < midValue) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int findLowerBoundOf(int target, int left) {
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = students[mid];
            if (target <= midValue) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}