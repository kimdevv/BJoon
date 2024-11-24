import java.io.*;
import java.util.*;

public class InputtingBox_1965 {
    private static int n; // 상자의 개수
    private static List<Integer> boxSize = new ArrayList<>();
    private static int[] dp = new int[1001];
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        inputBox();
        processDP();
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static void inputBox() throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int nextSize = Integer.parseInt(stringTokenizer.nextToken());
            boxSize.add(nextSize);
        }
    }

    private static void processDP() {
        for (int i = 0; i < n; i++) {
            int number = boxSize.get(i);
            dp[number] = Arrays.stream(Arrays.copyOfRange(dp, 0, number)) // 현재 이전의 최댓값을 구함
                    .max().getAsInt() + 1;
        }
    }
}