import java.io.*;
import java.util.*;

public class Coin2_2294 {
    static int n; // 동전의 종류
    static int k; // 원하는 가치의 합
    static int[] dpArray;
    static ArrayList<Integer> coinArray = new ArrayList<>();

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        inputNK(); // n과 k를 입력받는다.
        inputCoinValue(); // 동전을 입력받는다.
        setDpArray(); // DP를 완성시킨다.
        outputResult(); // 결과를 출력한다.
    }

    private static void inputNK() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void inputCoinValue() throws IOException {
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(bufferedReader.readLine());
            coinArray.add(value);
        }
    }

    private static void setDpArray() {
        dpArray = new int[k+1];
        Arrays.fill(dpArray, Integer.MAX_VALUE-1);
        dpArray[0] = 0;

        for (int coin : coinArray) {
            for (int j=coin; j<=k; j++) {
                dpArray[j] = Math.min(dpArray[j], dpArray[j-coin]+1);
            }
        }
    }

    private static void outputResult() {
        int result = dpArray[k];
        if (result == Integer.MAX_VALUE-1) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
}