import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CuteLion_15565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 인형 개수
        int K = Integer.parseInt(st.nextToken()); // 인형 개수 최소값

        List<Integer> lionIndex = new ArrayList<>(); // 라이언 인형의 인덱스
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int doll = Integer.parseInt(st.nextToken());
            if (doll == 1) {
                lionIndex.add(i);
            }
        }

        if (lionIndex.size() < K) {
            System.out.println(-1);
        } else { // 1이 K개 포함되는 최소 길이를 구한다.
            int length = 0;
            for (int i=0; i<K; i++) {
                length = lionIndex.get(i);
            }
            int result = length;

            for (int i=K; i<lionIndex.size(); i++) {
                length = lionIndex.get(i);
                length -= lionIndex.get(i - K + 1);
                result = Math.min(result, length);
            }
            System.out.println(result + 1);
        }
        br.close();
    }
}