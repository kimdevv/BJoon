import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoodFriend_3078 {

    private static int[] nameLengths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생의 수
        int k = Integer.parseInt(st.nextToken()); // 최대 차이 등수

        nameLengths = new int[n]; // 이름의 길이를 저장하는 배열
        for (int i=0; i< n; i++) {
            nameLengths[i] = br.readLine().length();
        }

        long[] count = new long[20 + 1]; // 각 이름 길이 별로 등장한 횟수를 저장하는 배열
        for (int i=0; i<= k; i++) {
            int currentLength = nameLengths[i];
            count[currentLength]++;
        }

        long result = countGoodFriends(count, 0);

        // i번째 사람은 [i, i+K] 범위 내에서 자신의 이름의 길이와 같은 사람의 수를 찾는다.
        // i-k번째 사람의 차례라면 나보다 바로 윗 사람(i-k-1)의 이름 길이를 제거하고 내 범위에 새로 추가되는 사람(i)의 이름 길이가 추가된다.
        for (int i=k+1; i<n; i++) {
            int previousLength = nameLengths[i - k - 1]; // 뺄 이름 길이
            count[previousLength]--;
            int currentLength = nameLengths[i]; // 추가할 이름 길이
            count[currentLength]++;
            result += countGoodFriends(count, i - k);
        }

        for (int i= n - k -1; i< n -1; i++) { // 슬라이딩 윈도우가 끝난 후, 남은 사람들의 경우도 계산한다.
            int previousLength = nameLengths[i];
            count[previousLength]--;
            result += countGoodFriends(count, i+1);
        }

        System.out.println(result);
        br.close();
    }

    private static long countGoodFriends(long[] count, int startIndex) {
        int obj = nameLengths[startIndex]; // 현재 위치한 사람의 이름 길이
        return count[obj] - 1; // 나 자신을 뺀 같은 이름을 가진 사람의 수
    }
}
