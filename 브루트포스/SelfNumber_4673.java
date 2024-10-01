import java.io.IOException;

public class SelfNumber_4673 {

    public static void main(String[] args) throws IOException {
        int[] list = new int[10001];

        // 1부터 10000까지 돌면서 모두 구함
        for (int i=1; i<10001; i++) {
            if(list[i] == 1) continue;

            int now = i;
            while (now <= 10000) {
                if (now != i) {
                    list[now] = 1;
                }
                now = kaprekar(now);
            }
        }

        for (int i=1; i<list.length; i++) {
            if (list[i] != 1) {
                System.out.println(i);
            }
        }
    }

    public static int kaprekar(int number) {
        int tmp = number;
        while (number != 0) {
            tmp += number % 10;
            number /= 10;
        }

        return tmp;
    }

}
