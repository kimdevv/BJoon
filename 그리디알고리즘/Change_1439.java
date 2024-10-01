import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change_1439 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int change = 1000 - stoi(br.readLine());

        int count = 0;
        while (change > 0) {
            if (change >= 500) {
                change -= 500;
                count++;
            } else if (change >= 100) {
                change -= 100;
                count++;
            } else if (change >= 50) {
                change -= 50;
                count++;
            } else if (change >= 10) {
                change -= 10;
                count++;
            } else if (change >= 5) {
                change -= 5;
                count++;
            } else if (change >= 1) {
                change -= 1;
                count++;
            }
        }

        System.out.println(count);
    }
}