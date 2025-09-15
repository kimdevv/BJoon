import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExchangingString_1522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line += line;

        int result = Integer.MAX_VALUE;
        int countOfA = countA(line);
        for (int i=0; i<line.length() / 2; i++) {
            String substring = line.substring(i, i+countOfA);
            int countOfChanges = countChanges(substring);
            result = Math.min(result, countOfChanges);
        }

        System.out.println(result);
        br.close();
    }

    private static int countA(String line) {
        int count = 0;
        for (int i=0; i<line.length() / 2; i++) {
            if (line.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    private static int countChanges(String line) {
        int count = 0;
        for (int i=0; i<line.length(); i++) {
            if (line.charAt(i) == 'b') {
                count++;
            }
        }
        return count;
    }
}