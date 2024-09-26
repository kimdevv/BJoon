import java.io.*;
import java.util.*;

public class ChoosingNumber {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = stoi(stringTokenizer.nextToken()); // 정수의 수
        int M = stoi(stringTokenizer.nextToken()); // 두 수의 차이

        int[] array = new int[N];
        for (int i=0; i<N; i++) {
            int number = stoi(bufferedReader.readLine());
            array[i] = number;
        }
        Arrays.sort(array);

        if (N==1) { // 수가 하나면
            System.out.println(array[0]); // 그 수를 출력
        } else {
            int min = Integer.MAX_VALUE;

            // 투 포인터
            int left = 0;
            int right = 1;
            while (left <= right && right < N) {
                int diff = array[right] - array[left];

                if (M > diff) { // M보다 차이가 더 작으면 차이를 키워줘야 하므로
                    right++; // 오른쪽 포인터(뺄셈 당하는 값)를 증가시킴
                } else if (M < diff) { // M보다 차이가 더 크면 차이를 줄여줘야 하므로
                    left++; // 왼쪽 포인터(빼는 값)를 증가시킴
                } else {
                    min = M; // 차이가 M이라면
                    break; // 더 볼 것 없이 M을 출력하면 됨(최솟값)
                }

                if (min > diff && diff >= M) { // 차이가 M보다 크면서 이전보다 더 작아졌다면 그 값을 최솟값으로 만든다
                    min = diff;
                }
            }

            System.out.println(min);
        }
    }
}