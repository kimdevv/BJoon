import java.io.*;
import java.util.*;

public class MakeRomeNumber_16922 {

    private static int[] NUMBERS = {1, 5, 10, 50};
    private static Set<Integer> result = new HashSet<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<NUMBERS.length; i++) {
            dfs(NUMBERS[i], 1, 0);
        }
        System.out.println(result.size());

        br.close();
    }

    private static void dfs(int start, int depth, int idx) {
        if (depth == N) {
            result.add(start);
            return;
        }
        for (int i=idx; i<NUMBERS.length; i++) {
            dfs(start + NUMBERS[i], depth + 1, i);
        }
    }
}
