import java.io.*;
import java.util.*;

public class Height_2458 {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()); // 학생들의 수
        int M = stoi(st.nextToken()); // 두 학생 키를 비교한 횟수

        // 자신보다 키가 큰 사람, 작은 사람 배열을 각각 만듦
        boolean[][] shortList = new boolean[N+1][N+1];
        boolean[][] tallList = new boolean[N+1][N+1];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int shorter = stoi(st.nextToken());
            int taller = stoi(st.nextToken());

            shortList[taller][shorter] = true;
            tallList[shorter][taller] = true;
        }

        // 자신보다 큰 사람은 tallList에, 작은 사람은 shortList에 저장
        for (int i=1; i<=N; i++) { // 거쳐가는 노드
            for (int j=1; j<=N; j++) { // 시작 노드
                for (int k=1; k<=N; k++) { // 끝 노드
                    if (shortList[j][i] && shortList[i][k]) {
                        shortList[j][k] = true;
                    }
                    if (tallList[j][i] && tallList[i][k]) {
                        tallList[j][k] = true;
                    }
                }
            }
        }

        // 키를 총 비교한 횟수(shorList의 true 개수 + tallList의 true 개수)가 N-1이라면, 그 사람의 위치를 정확히 알 수 있다
        int canCount = 0;
        for (int i=1; i<=N; i++) {
            int shortCount = 0;
            int tallCount = 0;

            for (int j=1; j<=N; j++) {
                if (shortList[i][j]) {
                    shortCount++;
                }
                if (tallList[i][j]) {
                    tallCount++;
                }
            }

            if (shortCount + tallCount == N-1) {
                canCount++;
            }
        }

        System.out.println(canCount);
    }
}