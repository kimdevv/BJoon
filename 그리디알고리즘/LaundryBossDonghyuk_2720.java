import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LaundryBossDonghyuk_2720 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        for (int i=0; i<T; i++) {
            int C = stoi(br.readLine());

            int quarter = C / 25;
            C %= 25;

            int dime = C / 10;
            C %= 10;

            int nickel = C / 5;
            C %= 5;

            int penny = C / 1;

            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}