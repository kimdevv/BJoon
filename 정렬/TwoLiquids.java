import java.io.*;
import java.util.*;

public class TwoLiquids {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine()); // 전체 용액의 수
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            array[i] = stoi(st.nextToken());
        }
        Arrays.sort(array); // 오름차 순으로 정렬 (-99, -2, -1, 4, 98)

        // 양끝에서 가운데로 이동하는 투 포인터
        int leftPointer = 0;
        int rightPointer = N-1;

        int resultSum = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;
        while(leftPointer < rightPointer) {
            int tempSum = array[leftPointer] + array[rightPointer];
            if (resultSum > Math.abs(tempSum)) {
                resultSum = Math.abs(tempSum);
                resultLeft = array[leftPointer];
                resultRight = array[rightPointer];
            }

            if (tempSum > 0) { // 합계가 양수면 값이 더 작아져야 함
                rightPointer--;
            } else { // 합계가 음수면 값이 더 커져야 함
                leftPointer++;
            }
        }

        System.out.println(resultLeft + " " + resultRight);
    }
}