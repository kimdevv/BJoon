import java.util.*;

public class Lie_1043 {
    private static BufferedReader bufferedReader;
    private static int N; // 사람의 수
    private static int M; // 파티의 수
    private static boolean[] factKnowers;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputNM();
        inputFactKnowers();
    }

    private static void inputNM() throws IOException {
        StringTokenizer NM = new StringTokenizer(bufferedReader.readLine());
        N = Integer.valueOf(NM.nextToken());
        M = Integer.valueOf(NM.nextToken());
    }

    private static void inputFactKnowers throws IOException {
        factKnowers = new boolean[N+1];
        StringTokenizer rawFactKnowers = StringTokenizer(bufferedReader.readLine, " ");
        int factKnowerCount = Integer.valueOf(rawFactKnowers.nextToken());
        while(rawFactKnowers.hasMoreToken()) {
            int factKnower = Integer.valueOf(rawFactKnowers.nextToken());
            factKnowers[factKnower] = true;
        }
    }
}