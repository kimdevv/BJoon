import java.io.*;
import java.util.*;

public class BlackFriday_18114 {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = stoi(stringTokenizer.nextToken()); // 물건의 개수
        int C = stoi(stringTokenizer.nextToken()); // 제시하는 무게

        // 무게 입력받은 후 정렬
        int[] array = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N; i++) {
            array[i] = stoi(stringTokenizer.nextToken());
        }
        Arrays.sort(array);


        if(binarySearch(array, C, 0, N-1)) { // 1개로 무게를 채울 수 있는지 검사
            System.out.println(1);
        } else { // 1개로 물건을 채울 수 없다면 2개, 3개로 채워야 함
            int count = 0;

            // 투포인터를 사용해서 2개로 채울 수 있는지 확인
            int left = 0;
            int right = N-1;
            while (left < right) {
                int sum = array[left] + array[right];

                if (sum > C) { // 무게가 더 큼 -> right를 줄여줘야 함
                    right--;
                } else if (sum == C) { // 2개로 무게를 채울 수 있다면 1 반환
                    count = 1;
                    break;
                } else { // 무게가 더 작음 -> 사이에 수가 하나 있다면 1 반환
                    if (binarySearch(array, C-sum, left+1, right-1)) { // 사이에 수 하나를 찾는다
                        count = 1;
                        break;
                    } else { // 없으면 계속해서 찾음
                        left++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static boolean binarySearch(int[] array, int findValue, int left, int right) {
        while (left <= right) {
            int mid = (left+right) / 2;

            if (array[mid] > findValue) { // mid 줄여야 함 -> right 감소
                right = mid-1;
            } else if (array[mid] < findValue) { // mid 늘려야 함 -> left 증가
                left = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}