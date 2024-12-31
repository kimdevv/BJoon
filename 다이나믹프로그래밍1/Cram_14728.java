import java.io.*;
import java.util.*;

class Study implements Comparable<Study> {
    public int time;
    public int score;

    public Study(int time, int score) {
        this.time = time;
        this.score = score;
    }

    @Override
    public int compareTo(Study other) {
        if (this.time == other.time) {
            return other.score - this.score;
        }
        return this.time - other.time;
    }
}

public class Cram_14728 {
    private static int N; // 시험의 단원 개수
    private static int T; // 시험까지 공부할 수 있는 총 시간

    private static PriorityQueue<Study> studies;
    private static int[] dp;

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        initializeBufferedReader();
        inputNT();
        initializeStudies();
        processDP();
        outputResult();
    }

    private static void initializeBufferedReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void inputNT() throws IOException {
        StringTokenizer NT = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(NT.nextToken());
        T = Integer.parseInt(NT.nextToken());
    }

    private static void initializeStudies() throws IOException {
        studies = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            StringTokenizer studyTimeAndScore = new StringTokenizer(bufferedReader.readLine());
            int studyTime = Integer.parseInt(studyTimeAndScore.nextToken());
            int studyScore = Integer.parseInt(studyTimeAndScore.nextToken());
            studies.add(new Study(studyTime, studyScore));
        }
    }

    private static void processDP() {
        dp = new int[10_000 + 1];

        int previousIndex = 0;
        for (int i=1; i<dp.length; i++) {
            if (studies.isEmpty()) {
                dp[i] = dp[previousIndex] + dp[i - previousIndex];
                continue;
            }

            if (i == studies.peek().time) {
                dp[i] = Math.max(dp[previousIndex] + dp[i - previousIndex-1], studies.poll().score);
                previousIndex = i;
            } else {
                dp[i] = dp[previousIndex] + dp[i - previousIndex];
            }
        }
    }

    private static void outputResult() {
        System.out.println(dp[T]);
        //System.out.println(Arrays.toString(dp));
    }
}

/*
    3 3
    1 1
    1 5
    1 9
 */