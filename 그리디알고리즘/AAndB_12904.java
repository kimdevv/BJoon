import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AAndB_12904 {

    private static String S;
    private static String T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            } else if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        System.out.println(S.toString().contentEquals(T) ? 1 : 0);
        br.close();
    }
}
