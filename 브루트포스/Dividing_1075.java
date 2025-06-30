import java.io.*;

public class Dividing_1075 {

    private static int N;
    private static int F;

    public static void main(String[] args) throws IOException {
        input();
        progress();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());
        br.close();
    }

    private static void progress() {
        int base = (N / 100) * 100;
        for (int i=0; i<=99; i++) {
            if ((base + i) % F == 0) {
                System.out.printf("%02d", i);
                return;
            }
        }
    }
}
