import java.io.*;
import java.util.*;

public class EatOrEaten_7795 {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(bufferedReader.readLine()); // 테스트 케이스의 개수
        while (T>0) {
            T--;

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int ALength = stoi(stringTokenizer.nextToken());
            int BLength = stoi(stringTokenizer.nextToken());

            // A, B의ㅎ 수를 입력받고 정렬
            int[] A = new int[ALength];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i=0; i<ALength; i++) {
                A[i] = stoi(stringTokenizer.nextToken());
            }

            int[] B = new int[BLength];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i=0; i<BLength; i++) {
                B[i] = stoi(stringTokenizer.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            // 투포인터
            int count = 0;
            int APointer = 0;
            int BPointer = 0;
            while (true) {
                if (APointer >= ALength) {
                    count -= BPointer;
                    break;
                } else if (BPointer >= BLength) {
                    count += (ALength - APointer - 1) * BPointer;
                    break;
                }

                int numberA = A[APointer];
                int numberB = B[BPointer];

                if (numberA > numberB) {
                    count++;
                    BPointer++;
                } else {
                    count += BPointer;
                    APointer++;
                }
            }

            System.out.println(count);
        }
    }
}