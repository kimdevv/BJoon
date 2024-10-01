import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class JewelryThief_1202 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()); // 보석 개수
        int K = stoi(st.nextToken()); // 가방 개수

        // 보석 정보 초기화
        int[][] jrs = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer tempst = new StringTokenizer(br.readLine());
            jrs[i][0] = stoi(tempst.nextToken());
            jrs[i][1] = stoi(tempst.nextToken());
        }
        // 무게 기준으로 오름차순 정리
        Arrays.sort(jrs, (o1, o2) -> { return o1[0]-o2[0]; });

        // 가방 정보 초기화
        Integer[] bags = new Integer[K];
        for (int i=0; i<K; i++) {
            bags[i] = stoi(br.readLine());
        }
        // 수용량 기준으로 오름차순 정리
        Arrays.sort(bags);

        long sum = 0;
        int now = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<bags.length; i++) {
            long capacity = bags[i];

            while (now < jrs.length && jrs[now][0]<=capacity) {
                pQ.offer(jrs[now][1]);
                now++;
            }
            if (pQ.size() > 0) {
                long s = pQ.poll();
                sum += s;
            }
        }

        System.out.println(sum);

        br.close();
    }
}