import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewRecruit_1946 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());
        for (int l=0; l<T; l++) {

            int N = stoi(br.readLine());
            Integer[] score = new Integer[N+1];
            score[0] = 0;

            for(int k=1; k<=N; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[stoi(st.nextToken())] = stoi(st.nextToken()); // 면접 순위
            }

            int checkArr = Integer.MAX_VALUE;
            int result = 0;
            for (int i=1; i<=N; i++) {
                if (score[i] < checkArr) {
                    checkArr = score[i];
                    result++;
                }
            }

            System.out.println(result);

        }

        br.close();
    }
}