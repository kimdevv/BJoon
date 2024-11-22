import java.io.*;

public class Tile01_1904 {
    private static final int DIVISOR = 15746;
    private static int N;
    private static long dp[] = new long[1000001];

    public static void main(String[] args) throws IOException {
        inputN();
        processDP();
        System.out.println(dp[N]);
    }

    private static void inputN() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
    }

    private static void processDP() {
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % DIVISOR;
        }
    }
}