import java.io.*;
import java.util.*;

public class TwoLiquids {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine()); // 전체 용액의 개수
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            array[i] = stoi(st.nextToken());
        }
        Arrays.sort(array);

        int closer = Integer.MAX_VALUE;
        int one = 0;
        int two = 0;

        first: for (int i=0; i<=N/2; i++) {
            for (int j=N-1; j>i; j--) {
                //System.out.println(i + " " + j);
                int tempSum = Math.abs(array[j] + array[i]);
                if (closer >= tempSum) {
                    closer = tempSum;
                    one = array[i];
                    two = array[j];
                } else {
                    continue first;
                }
            }
        }

        System.out.println(one + " " + two);
    }
}