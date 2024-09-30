import java.io.*;
import java.util.*;

public class SumOfTripleNumber {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 수의 개수

        // 수 입력받은 후 정렬
        int[] array = new int[N];
        for (int i=0; i<N; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);

        // 두 수를 더한 수를 저장한다
        ArrayList<Integer> sumArray = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sumArray.add(array[i] + array[j]);
            }
        }
        Collections.sort(sumArray);

        // 이분탐색
        // x + y + z = k -> x + y = k - z
        first: for (int i=N-1; i>=0; i--) {
            for (int j=N-1; j>=0; j--) {
                int expectedValue = array[i] - array[j];

                int result = binarySearch(sumArray, expectedValue, 0, sumArray.size()-1);
                if (result != -1) { // 수를 찾았다면
                    System.out.println(array[i]);
                    break first;
                }
            }
        }
    }

    public static int binarySearch(ArrayList<Integer> array, int expectedValue, int left, int right) {
        int mid = (left+right) / 2;
        if (left > right) { // 종료조건
            return -1;
        }

        if (array.get(mid) > expectedValue) { // mid를 줄여줘야 함 -> right 감소
            return binarySearch(array, expectedValue, left, mid-1);
        } else if (array.get(mid) < expectedValue) { // mid를 키워줘야 함 -> left 증가
            return binarySearch(array, expectedValue, mid+1, right);
        } else { // array[mid] == expectedValue
            return expectedValue;
        }
    }
}