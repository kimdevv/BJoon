import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bulk {
    public static int stoi(String st) {
        return Integer.parseInt(st);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[][] person = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i][0] = stoi(st.nextToken());
            person[i][1] = stoi(st.nextToken());
        }

        // 배열 하나씩 돌면서 자기보다 덩치가 큰 요소가 있는지 확인
        for (int i=0; i<N; i++) {
            int count = 1;
            for (int j=0; j<N; j++) {
                if (i == j) continue;

                // 덩치가 큰 사람이 있다면
                if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                    count++; // 순위를 1씩 낮춘다
                }
            }
            System.out.print(count + " ");
        }
    }
}
