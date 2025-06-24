import java.io.*;
import java.util.*;

public class FourSquares_17626 {

    private static int N;
    private static int[] dpArray;

    public static void main(String[] args) throws IOException {
        inputN();
        processDP();
        outputResult();
    }

    private static void inputN() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

    private static void processDP() {
        dpArray = new int[N+1];
        Arrays.fill(dpArray, Integer.MAX_VALUE);

        int squareNumber = 0;
        for (int i=1; i<dpArray.length; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt == Math.round(sqrt)) { // 제곱수라면
                squareNumber = (int) sqrt;
                dpArray[i] = 1; // 하나만으로 가능
                continue;
            }
            for (int j=1; j<=squareNumber; j++) { // 제곱수가 아니라면
                dpArray[i] = Math.min(dpArray[i], dpArray[i-(j*j)] + 1); // 어떤 제곱수를 더해야 최솟값이 되는지 구해서 저장한다
            }
        }
    }

    private static void outputResult() {
        System.out.println(dpArray[N]);
    }
}
