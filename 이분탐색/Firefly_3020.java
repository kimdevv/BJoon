import java.io.*;
import java.util.*;

public class Firefly_3020 {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = stoi(stringTokenizer.nextToken()); // 장애물의 수
        int H = stoi(stringTokenizer.nextToken()); // 장애물의 최대 크기

        int[] plusArray = new int[H+1]; // 석순의 높이 별 파괴 횟수 저장
        int[] minusArray = new int[H+1]; // 종유석의 높이 별 파괴 횟수 저장
        for(int i=0; i<N; i++) {
            int height = stoi(bufferedReader.readLine());
            if (i%2 == 0) { // i가 양수 번째라면(석순이라면)
                plusArray[height]++;
            } else { // i가 음수 번째라면(종유석이라면)
                minusArray[H-height+1]++;
            }
        }

        for (int i=H-1; i>=1; i--) {
            plusArray[i] += plusArray[i+1]; // 석순은 큰 수부터 하나씩 이전 장애물 횟수를 다음 장애물 횟수에 더함
            minusArray[H-i+1] += minusArray[H-i]; // 종유석은 작은 수부터 하나씩 이전 장애물 횟수를 다음 장애물 횟수에 더함
        }

        // 석순, 종유석 두 장애물 횟수를 하나로 합침
        int[] array = new int[H+1];
        for (int i=1; i<=H; i++) {
            array[i] = plusArray[i] + minusArray[i];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i=1; i<=H; i++) {
            if (min == array[i]) { // 장애물 파괴 횟수가 최솟값과 같다면
                count++; // 개수를 하나 더함
            } else if (min > array[i]) { // 장애물 파괴 횟수 최솟값을 구함
                min = array[i];
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }
}