import java.io.*;
import java.util.*;

public class NumberCard2_10816 {

    private static final int[] counts = new int[20000000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[N]; // 카드에 적힌 숫자
        for (int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i=0; i<M; i++) {
            int number = Integer.parseInt(st.nextToken());
            findCountsOf(number, cards);
            result.append(counts[number + 10_000_000]).append(" ");
        }

        System.out.println(result);
        br.close();
    }

    private static void findCountsOf(int target, int[] cards) {
        int upperBound = findUpperBoundOf(target, cards);
        int lowerBound = findLowerBoundOf(target, cards);
        counts[target + 10_000_000] = upperBound - lowerBound;
    }

    private static int findUpperBoundOf(int target, int[] cards) {
        int left = 0;
        int right = cards.length ;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = cards[mid];
            if (midValue > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static int findLowerBoundOf(int target, int[] cards) {
        int left = 0;
        int right = cards.length ;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = cards[mid];
            if (midValue >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}