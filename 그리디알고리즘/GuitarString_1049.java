import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GuitarString_1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄의 개수
        int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 개수

        PriorityQueue<Integer> packagePrices = new PriorityQueue<>();
        PriorityQueue<Integer> unitPrices = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int packagePrice = Integer.parseInt(st.nextToken());
            packagePrices.offer(packagePrice);
            int unitPrice = Integer.parseInt(st.nextToken());
            unitPrices.offer(unitPrice);
        }

        int min = Integer.MAX_VALUE;
        int unitPrice = unitPrices.poll();
        min = Math.min(min, unitPrice * N);

        int packagePrice = packagePrices.poll();
        min = Math.min(min, (packagePrice * (N / 6)) + (unitPrice * (N % 6)));
        min = Math.min(min, packagePrice * (N / 6 + 1));

        System.out.println(min);
        br.close();
    }
}