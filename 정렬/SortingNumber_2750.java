import java.io.*;
import java.util.*;

public class SortingNumber_2750 {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken()); // 배열의 크기

        int[] array = new int[N];
        for (int i=0; i<N; i++) {
            array[i] = stoi(br.readLine());
        }

        quickSort(array, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(array[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void quickSort(int[] array, int start, int end) {
        // 종료 조건
        if (start >= end) {
            return;
        }

        int pivot = start; // 가장 왼쪽 요소를 피벗으로 설정
        int low = start + 1; // 현재 부분 배열의 왼쪽
        int high = end; // 현재 부분 배열의 오른쪽

        while (low <= high) {
            while (low <= end && array[low] <= array[pivot]) { // 피벗보다 큰 값을 만날 때까지
                low++;
            }
            while (high > start && array[high] >= array[pivot]) { // 피벗보다 작은 값을 찾을 때까지
                high--;
            }

            // 자 이제 피벗보다 큰 값의 id, 작은 값의 id를 다 찾음!

            if (low > high) {
                swap(array, high, pivot); // 엇갈리면 high(지금 더 왼쪽)을 피벗과 교체
            } else {
                swap(array, low, high); // 엇갈리지 않았다면 low과 high 값을 교체
            }

            // 피벗의 위치가 엇갈렸다면, 피벗의 바뀐 위치를 기준으로
            // 왼쪽 오른쪽 배열 나눠서 계속 quickSort
            // 이 경우 high의 값이 피벗이 되었기 때문에 0~(high-1)과 (high+1)~end로 나눔
            quickSort(array, start, high-1);
            quickSort(array, high+1, end);
        }
    }

    public static void swap(int[] array, int one, int two) {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}