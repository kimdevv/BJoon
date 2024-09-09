import java.io.*;
import java.util.*;

public class Height {
    public static class Compare {
        int longer;
        int underCount;

        Compare(int longer, int underCount) {
            this.longer = longer;
            this.underCount = underCount;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()); // 학생의 수
        int M = stoi(st.nextToken()); // 두 학생 키를 비교한 횟수

        // List<Compare>[] compareList = new List[N+1];
        // for (int i=1; i<=N; i++) {
        //   compareList[i] = new ArrayList<>();
        // }

        // for (int i=0; i<M; i++) {
        //   st = new StringTokenizer(br.readLine());
        //   int shorter = stoi(st.nextToken());
        //   int longer = stoi(st.nextToken());

        //   compareList[shorter].add(new Compare(longer));
        // }

        //
        // 일렬로 쭉 세워서 왼쪽에 몇 명, 오른쪽에 몇 명 순서대로 넣은 후에
        // 왼 + 오 = N-1인 사람 찾으면 될 것 같기도??
        //


        int[] compareCountList = new int[N+1];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int shorter = stoi(st.nextToken());
            int longer = stoi(st.nextToken());

            compareCountList[longer]++;
        }


    }
}