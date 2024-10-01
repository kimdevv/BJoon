import java.io.*;
import java.util.*;

public class Statistics_2108 {
    static int average = 0; // 평균
    static int middle; // 중앙값
    static int mode; // 최빈값
    static int range; // 범위

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine()); // 수의 개수 (홀수)
        int[] array = new int[N];

        for (int i=0; i<N; i++) {
            int number = stoi(br.readLine());

            average += number;
            array[i] = number;
        }
        Arrays.sort(array);

        average = (int)Math.round((double)average/N); //평균을 구함
        middle = array[N/2]; // 중앙값을 구함
        range = array[N-1] - array[0]; // 범위를 구함

        // 최빈값 개수를 저장하는 배열 (2를 넘기면 안 됨)
        int[] modeCheck = new int[N];

        int prev = array[0];
        mode = prev;

        int nowMax = 1; // 현재 최반값 요소가 등장한 개수
        int nowCount = 1;
        for (int i=1; i<N; i++) {
            if (prev == array[i]) { // 이전 값과 같은지 검사한 후 같다면 개수 올림
                nowCount++;
            } else { // 이전 값과 다른 값이 나온다면
                if (modeCheck[nowCount] < 2 && nowMax <= nowCount) {
                    modeCheck[nowCount]++;
                    nowMax = nowCount;
                    mode = prev;
                }
                nowCount = 1;
            }
            prev = array[i];
        }

        // 마지막 요소도 최반값인지 검사한다
        if (N>1 && modeCheck[nowCount] < 2 && nowMax <= nowCount) {
            mode = prev;
        }

        System.out.println(average + "\n" + middle + "\n" + mode + "\n" + range);
    }
}