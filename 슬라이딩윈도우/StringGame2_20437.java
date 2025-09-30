import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class StringGame2_20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int round=0; round<T; round++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List[] counts = new ArrayList['z' - 'a' + 1]; // a ~ z마다 등장 인덱스를 담을 ArrayLists 배열
            for (int i=0; i<counts.length; i++) {
                counts[i] = new ArrayList<>();
            }
            for (int i=0; i<W.length(); i++) {
                char number = W.charAt(i);
                counts[number - 'a'].add(i); // 현재 알파벳이 위치한 인덱스를 담는다
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (List<Integer> list : counts) {
                if (list.size() < K) { // 알파벳 개수가 K개를 넘지 않는다면 스킵한다
                    continue;
                }
                int result = list.get(K - 1) - list.get(0) + 1; // K개의 인접한 알파벳 간 거리를 구한다
                min = Math.min(min, result);
                max = Math.max(max, result);

                for (int k = K; k < list.size(); k++) {
                    result = list.get(k) - list.get(k - K + 1) + 1; // K개의 인접한 알파벳 간 거리를 구한다
                    min = Math.min(min, result);
                    max = Math.max(max, result);
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
        br.close();
    }
}
