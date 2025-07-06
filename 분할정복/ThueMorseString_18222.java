import java.io.*;

public class ThueMorseString_18222 {

    private static final long[] powers = new long[60 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        powers[0] = 1;
        for (int i=1; i<powers.length; i++) {
            powers[i] = powers[i-1] * 2; // 10^18까지 표현할 수 있는 2의 제곱수 저장
        }

        long k = Long.parseLong(br.readLine());
        System.out.println(divideAndConquer(k));

        br.close();
    }

    private static long divideAndConquer(long index) {
        if (index == 1) {
            return 0;
        }
        for (int i=0; i<powers.length; i++) {
            if (index <= powers[i]) { // 자신을 포함할 수 있는 2의 제곱수를 찾는다
                // 그럼 그 직전의 제곱수에서 자신의 인덱스와 똑같은 위치의 수를 구해서 반전(1 빼기)해준다.
                return 1 - divideAndConquer(index - powers[i-1]);
            }
        }
        return 0;
    }
}