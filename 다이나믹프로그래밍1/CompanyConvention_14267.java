import java.io.*;
import java.util.*;

public class CompanyConvention_14267 {
    private static int N; // 회사의 직원 수
    private static int M; // 최초의 칭찬 횟수
    private static BufferedReader bufferedReader;

    private static List<Worker> workers;
    private static int[] dp;

    private static class Worker {
        public List<Integer> subordinates;

        public Worker() {
            this.subordinates = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        initializeBufferedReader();
        inputNM();
        inputBosses();
        inputCompliments();
        processDP(1);
        outputResult();
    }

    private static void initializeBufferedReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void inputNM() throws IOException {
        StringTokenizer NM = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());

        workers = new ArrayList<>();
        for (int i=0; i<N+1; i++) {
            workers.add(new Worker());
        }
    }

    private static void inputBosses() throws IOException {
        StringTokenizer bosses = new StringTokenizer(bufferedReader.readLine());
        for (int i=1; i<N+1; i++) {
            int boss = Integer.parseInt(bosses.nextToken());
            if (boss == -1) {
                continue;
            }
            workers.get(boss).subordinates.add(i);
        }
    }

    private static void inputCompliments() throws IOException {
        dp = new int[N+1];
        for (int i=0; i<M; i++) {
            StringTokenizer workerAndCompliment = new StringTokenizer(bufferedReader.readLine());
            int worker = Integer.parseInt(workerAndCompliment.nextToken());
            int compliment = Integer.parseInt(workerAndCompliment.nextToken());
            dp[worker] += compliment;
        }
    }

    private static void processDP(int index) {
        Worker worker = workers.get(index);
        for (int subordinate : worker.subordinates) {
            dp[subordinate] += dp[index];
            processDP(subordinate);
        }
    }

    private static void increaseSubordinatesCompliments(List<Integer> subordinates, int increaseCompliments) {
        for (int index : subordinates) {
            dp[index]+= increaseCompliments;
            Worker worker = workers.get(index);
            increaseSubordinatesCompliments(worker.subordinates, increaseCompliments);
        }
    }

    private static void outputResult() {
        StringBuilder result = new StringBuilder();
        for (int i=1; i<dp.length; i++) {
            result.append(dp[i] + " ");
        }
        System.out.println(result);
    }
}