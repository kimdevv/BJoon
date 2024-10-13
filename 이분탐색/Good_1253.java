import java.io.*;
import java.util.*;

public class Main {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(bufferedReader.readLine()); // 수의 개수

        int zeroCount = 0; // 0의 개수
        int[] array = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N; i++) {
            int number = stoi(stringTokenizer.nextToken());
            array[i] = number;

            if (number == 0) { // 수가 0이라면 0의 개수를 하나 증가시킴
                zeroCount++;
            }
        }
        Arrays.sort(array);

        // 두 수의 합을 구한 리스트
        ArrayList<Integer> sumArray = new ArrayList<>();
        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                if (array[i] != 0 && array[j] != 0) { // 0이 아닌 수들만 더한다
                    sumArray.add(array[i] + array[j]);
                }
            }
        }

        if (zeroCount > 0) { // 수 중에 0이 있었다면
            int previousNumber = array[0];
            for (int i=1; i<N; i++) { // 중복되는 수가 있을 경우에만 그 수에 0을 더한 값을 리스트에 담는다
                if (previousNumber == array[i] && array[i] != 0) {
                    sumArray.add(array[i]);
                }
                previousNumber = array[i];
            }

            if (zeroCount >= 3) { // 0의 개수가 3 이상이라면
                sumArray.add(0); // 0도 포함할 수 있다
            }
        }
        Collections.sort(sumArray);

        // 합 리스트에서 해당되는 수를 찾아서 개수를 구함
        int count = 0;
        for (int k=0; k<N; k++) {
            int now = array[k];

            int binaryResult = Collections.binarySearch(sumArray, now);
            if (binaryResult > -1) {
                count++;
            }
        }

        System.out.println(count);
    }
}