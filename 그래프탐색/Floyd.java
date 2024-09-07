import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine()); // 도시의 개수
        int m = stoi(br.readLine()); // 버스의 개수

        // 각 지역으로 가는 초기 비용 설정
        int[][] array = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(array[i], 100_000_000);
            array[i][i] = 0;
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int cost = stoi(st.nextToken());

            if (array[start][end] > cost) {
                array[start][end] = cost;
            }
        }

        // 플로이드-워셜 알고리즘
        for (int i=1; i<=n; i++) { // 거쳐가는 도시
            for (int j=1; j<=n; j++) { // 출발 도시
                for (int k=1; k<=n; k++) { // 도착 도시
                    if (array[j][k] > array[j][i]+array[i][k]) {
                        array[j][k] = array[j][i]+array[i][k];
                    }
                }
            }
        }

        // 각 도시의 최소 비용 출력.
        // 100,000,000의 비용을 가지는 경우 0으로 바꾸어 출력한다.
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (array[i][j] >= 100_000_000) {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
