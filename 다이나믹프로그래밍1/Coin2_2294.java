import java.io.*;
import java.util.*;

public class Coin2_2294 {
    static int n; // 동전의 종류
    static int k; // 원하는 가치의 합
    static int[] dpArray;
    static boolean[] coinArray = new boolean[100001];

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        dpArray = new int[k+1];
        Arrays.fill(dpArray, -1);

        inputCoinValue();
        setDpArray();

        System.out.println(dpArray[k]);
    }

    public static void inputCoinValue() throws IOException {
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(bufferedReader.readLine());
            coinArray[value] = true;
        }
    }

    public static void setDpArray() {
        for (int i=1; i<100001; i++) {
            if (coinArray[i]) {
                for (int j=1; i*j<=k; j++) {
                    dpArray[i*j] = j;
                }
            }
        }
    }
}