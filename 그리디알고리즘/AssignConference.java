import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class AssignConference {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());

        int last = Integer.MAX_VALUE;
        int lastIdx = 0;
        int[][] arr = new int[N][3];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = stoi(st.nextToken());
            arr[i][1] = stoi(st.nextToken());
            if (arr[i][1] <= last) {
                last = arr[i][1];
                lastIdx = i;
            }

            arr[i][2] = arr[i][1] - arr[i][0];
        }

        arr[lastIdx][0] = Integer.MIN_VALUE;
        arr[lastIdx][1] = Integer.MIN_VALUE;
        Arrays.sort(arr, (o1, o2) -> (o1[1] == o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]));

        int count = 1;
        for (int i=0; i<N; i++) {
            if (arr[i][0] >= last) {
                last = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}