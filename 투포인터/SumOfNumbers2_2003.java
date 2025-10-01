import java.io.*;
import java.util.*;

public class SumOfNumbers2_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int M = Integer.parseInt(st.nextToken()); // 목표 합

        int[] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int left = 0;
        int right = 0;
        int sum = numbers[0];
        while (right < N) {
            if (sum < M) {
                sum += numbers[++right];
            } else if (sum > M) {
                sum -= numbers[left++];
            } else {
                sum += numbers[++right];
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }
}