import java.util.*;
import java.io.*;

public class SumOfSubsequence_1182 {

    private static int S;
    private static int[] array;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 목표 값

        array = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            array[i+1] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<array.length; i++) {
            bruteforce(i, array[i]);
        }

        System.out.println(count);
        br.close();
    }

    private static void bruteforce(int index, int value) {
        if (value == S) {
            count++;
        }
        for (int i=index+1; i<array.length; i++) {
            bruteforce(i, value + array[i]);
        }
    }
}
