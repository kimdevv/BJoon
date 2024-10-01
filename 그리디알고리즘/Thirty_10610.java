import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class Thirty_10610 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Character> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순으로 우선순위 큐

        String N = br.readLine();

        long sum=0;
        long isZero = 0;
        for (int i=0; i<N.length(); i++) {
            char tmp = N.charAt(i);
            pQ.offer(tmp);

            int tmpInt = tmp - '0';
            if (tmpInt == 0) {
                isZero++;
            }
            sum += tmpInt;
        }

        if (sum != 0 && sum%3 == 0 && isZero > 0) { // 30의 배수라면
            StringBuilder result = new StringBuilder();
            long size = pQ.size();
            for (long i=0; i<size; i++) {
                result.append(pQ.poll());
            }

            System.out.println(result);
        } else { // 30의 배수가 아니라면 -1을 출력
            System.out.println(-1);
        }

        br.close();
    }
}