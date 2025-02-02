import java.io.*;
import java.util.*;

public class Shortcut_1446 {
    private static BufferedReader bufferedReader;
    private static int N; // 지름길의 개수
    private static int D; // 고속도로의 길이
    private static List<Shortcut> shortcuts;
    private static int[] dp;

    public static class Shortcut implements Comparable<Shortcut> {
        int start;
        int end;
        int length;

        public Shortcut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Shortcut other) {
            if (this.end == other.end) {
                return other.start - this.start;
            } else {
                return this.end - other.end;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        initializeBufferedReader();
        inputND();
        inputShortcuts();
        traverseGraph();
        outputResult();
    }

    private static void initializeBufferedReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void inputND() throws IOException {
        StringTokenizer ND = new StringTokenizer(bufferedReader.readLine());
        N = Integer.valueOf(ND.nextToken());
        D = Integer.valueOf(ND.nextToken());
    }

    private static void inputShortcuts() throws IOException {
        shortcuts = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer rawShortcut = new StringTokenizer(bufferedReader.readLine(), " ");
            int start = Integer.valueOf(rawShortcut.nextToken());
            int end = Integer.valueOf(rawShortcut.nextToken());
            int length = Integer.valueOf(rawShortcut.nextToken());
            shortcuts.add(new Shortcut(start, end, length));
        }
        Collections.sort(shortcuts);
    }

    private static void traverseGraph() {
        dp = new int[10_000 + 1];
        for (int i=1; i<=10_000; i++) {
            dp[i] = i;
        }
        for (int i=0; i<N; i++) {
            Shortcut nowShortcut = shortcuts.get(i);
            dp[nowShortcut.end] = Math.min(dp[nowShortcut.end], dp[nowShortcut.start] + nowShortcut.length);
            // 전 꺼에서 end 저거를 갱신했는데, 그 이후로 +1을 안 해줘서 그냥 i랑 비교해서 제대로 안 되는 듯 ?
        }

        for (int i=1; i<=10_000; i++) {
            dp[i] = Math.min(dp[i], dp[i-1]+1);
        }
    }

    private static void outputResult() {
        System.out.println(dp[D]);
        System.out.println(Arrays.toString(dp));
    }
}