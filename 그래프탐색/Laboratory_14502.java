import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Laboratory_14502 {
    static int N; // 세로 길이, y
    static int M; // 가로 길이, x
    static int[][] array;
    static int countZero = 0;
    static int max = Integer.MIN_VALUE;

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        array = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                int tmp = stoi(st2.nextToken());
                if (tmp == 0) {
                    countZero++;
                }
                array[i][j] = tmp;
            }
        }

        //for (int i=1; )
    }
}
