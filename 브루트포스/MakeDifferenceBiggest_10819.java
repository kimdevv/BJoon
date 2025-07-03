import java.io.*;
import java.util.*;

public class MakeDifferenceBiggest_10819 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Collections.reverseOrder());

        int middle = N / 2;
        int result1 = list.get(0) - list.get(middle); // 첫번째 인덱스부터 돌며 구한 최댓값
        for (int i=0; i<N; i++) {
            if (i == middle || N-1-i == middle) {
                break;
            }
            result1 += Math.abs(list.get(i) - list.get(N-1-i));
            if (i+1 == middle) {
                break;
            }
            result1 += Math.abs(list.get(i+1) - list.get(N-1-i));
        }

        int result2 = Math.abs(list.get(N-1) - list.get(middle)); // 마지막 인덱스부터 돌며 구한 최댓값
        for (int i=N-1; i>-0; i--) {
            if (i == middle || N-1-i == middle) {
                break;
            }
            result2 += Math.abs(list.get(i) - list.get(N-1-i));
            if (i-1 == middle) {
                break;
            }
            result2 += Math.abs(list.get(i-1) - list.get(N-1-i));
        }

        System.out.println(Math.max(result1, result2));
    }
}