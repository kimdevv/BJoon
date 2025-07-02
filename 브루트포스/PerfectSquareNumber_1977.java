import java.io.*;

public class PerfectSquareNumber_1977 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i=M; i<=N; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt == (int)sqrt) {
                sum += i;
                if (min == Integer.MAX_VALUE) {
                    min = i;
                }
            }
        }

        System.out.println(sum == 0 ? -1 : sum + "\n" + min);
    }
}