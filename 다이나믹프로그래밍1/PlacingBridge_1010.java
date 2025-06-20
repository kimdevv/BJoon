import java.io.*;
import java.util.*;

public class PlacingBridge_1010 {
    private static int T; // 테스트 케이스의 개수
    private static int[][] dpArray = new int[31][31];

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        inputT();
        processDP();
        outputResult();
    }

    private static void inputT() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    private static void processDP() {
        for (int i=0; i<dpArray.length; i++) {
            dpArray[i][0] = 1;
        }
        for (int i=1; i<dpArray.length; i++) {
            for (int j=1; j<dpArray[i].length; j++) {
                dpArray[i][j] = dpArray[i-1][j-1] + dpArray[i-1][j];
            }
        }
    }

    private static void outputResult() throws IOException {
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(dpArray[M][N]);
        }
    }
}