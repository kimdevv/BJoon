import java.io.*;
import java.util.*;

public class KthNumber {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()); // 수의 개수
        int K = stoi(st.nextToken()); // K번째 수

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            pq.add(stoi(st.nextToken()));
        }

        int now = 0;
        int result = 0;
        while (now != K) {
            now++;
            result = pq.poll();
        }

        System.out.println(result);
    }
}