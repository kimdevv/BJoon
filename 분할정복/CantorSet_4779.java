import java.io.*;

public class CantorSet_4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            String result = divideConquer(N);
            System.out.println(result);
        }
        br.close();
    }

    private static String divideConquer(int power) {
        if (power == 0) {
            return "-";
        }
        String left = divideConquer(power - 1);
        StringBuilder tmp = new StringBuilder();
        for (int i=0; i<Math.pow(3, power-1); i++) {
            tmp.append(' ');
        }
        String space = new String(tmp);
        return left + space + left;
    }
}