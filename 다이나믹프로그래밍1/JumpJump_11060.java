import java.io.*;
import java.util.*;

public class JumpJump_11060 {
    private static int N; // 미로의 크기
    private static int[] maze; // 미로 배열
    private static int[] dpArray = new int[2000]; // dp 배열
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        inputN();

        if (N == 1) { // 크기가 1이면 그 자리에서 바로 도착한 것.
            System.out.println(0);
        } else {
            initializeMaze(); // 미로 초기화
            processDP(); // DP 작업g
            printResult(); // 결과 출력
        }
    }

    private static void inputN() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        maze = new int[N];
    }

    private static void initializeMaze() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N; i++) {
            maze[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void processDP() {
        for (int i=0; i<N; i++) {
            if (validateDpElement(i)) { // 도달할 수 없는 요소에서 출발할 수 없게 한다
                continue;
            }
            for (int j=1; j<=maze[i]; j++) {
                if (dpArray[i+j] == 0) {
                    dpArray[i+j] = dpArray[i]+1;
                } else {
                    dpArray[i+j] = Math.min(dpArray[i+j], dpArray[i]+1);
                }
            }
        }
    }

    private static boolean validateDpElement(int index) {
        if (index != 0 && dpArray[index] == 0) {
            return true;
        }
        return false;
    }

    private static void printResult() {
        System.out.println(dpArray[N-1] == 0 ? -1 : dpArray[N-1]);
    }
}