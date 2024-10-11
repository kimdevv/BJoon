import java.io.*;
import java.util.*;

public class Immigration_3079 {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = stoi(stringTokenizer.nextToken()); // 입국심사대 개수
        int M = stoi(stringTokenizer.nextToken()); // 친구들의 수

        // 시간을 저장한다.
        int[] timeArray = new int[N];
        for (int i=0; i<N; i++) {
            timeArray[i] = stoi(bufferedReader.readLine());
        }

        long left = 0;
        long right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left+right) / 2; // mid 시간을 매개변수로 정함

            // mid시간 내에 처리할 수 있는 입국심사의 개수를 구함
            long available = 0;
            for (int i=0; i<N; i++) {
                available += mid / timeArray[i];

                if (available > M) { // 처리할 수 있는 입국심사 개수가 M개 초과하는 경우는 그냥 break해줘도 됨
                    break;
                }
            }

            if (available >= M) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left); // 어차피 left = mid = right가 될 때 종료니까 뭘 출력해도 상관 x
    }
}