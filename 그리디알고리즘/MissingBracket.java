import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

public class MissingBracket {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean bool = false;
        String expr = br.readLine();

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<expr.length(); i++) {
            char ch = expr.charAt(i);

            if (bool == false) { // -를 만나지 않았을 경우는 모두 더함
                if (ch == '-') {
                    sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                    bool = true;
                } else if (ch == '+') {
                    sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(ch);
                }
            } else { // -를 만난 이후부터는 모두 뺀다
                if (ch == '+' || ch == '-') {
                    sum -= Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(ch);
                }
            }
        }

        if (bool == false) {
            sum += Integer.parseInt(sb.toString());
        } else {
            sum -= Integer.parseInt(sb.toString());
        }

        System.out.println(sum);
    }
}