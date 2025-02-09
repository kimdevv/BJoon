import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Lie_1043 {
    private static BufferedReader bufferedReader;
    private static int N; // 사람의 수
    private static int M; // 파티의 수
    private static boolean[] factKnowers;
    private static String[] parties;
    private static List<Integer>[] knowers;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputNM();
        inputFactKnowers();
        inputParties();
        factKnowing();
        printLie();
    }

    private static void inputNM() throws IOException {
        StringTokenizer NM = new StringTokenizer(bufferedReader.readLine());
        N = Integer.valueOf(NM.nextToken());
        M = Integer.valueOf(NM.nextToken());
    }

    private static void inputFactKnowers() throws IOException {
        factKnowers = new boolean[N+1];
        StringTokenizer rawFactKnowers = new StringTokenizer(bufferedReader.readLine(), " ");
        int factKnowerCount = Integer.valueOf(rawFactKnowers.nextToken());
        while(rawFactKnowers.hasMoreTokens()) { // 토큰 개수만큼 반복
            int factKnower = Integer.valueOf(rawFactKnowers.nextToken());
            factKnowers[factKnower] = true;
        }
    }

    private static void inputParties() throws IOException {
        parties = new String[M];
        knowers = new List[N+1]; // 각 사람 별 파티에서 만나게 되는 사람들 리스트 배열
        for (int i=1; i<=N; i++) {
            knowers[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            String rawParty = bufferedReader.readLine();
            parties[i] = rawParty;
            String[] splittedParty = rawParty.split(" ");
            int personCount = Integer.valueOf(splittedParty[0]);
            for (int j=1; j<=personCount; j++) {
                for (int k=1; k<=personCount; k++) {
                    knowers[Integer.valueOf(splittedParty[j])].add(Integer.valueOf(splittedParty[k]));
                }
            }
        }
    }

    private static void factKnowing() {
        for (int i=1; i<=N; i++) {
            dfs(i);
        }
    }

    private static void dfs(int current) {
        for (int next : knowers[current]) {
            if (factKnowers[current]) {
                if (!factKnowers[next]) {
                    factKnowers[next] = true;
                    dfs(next);
                }
            }
        }
    }

    private static void printLie() {
        int lieCount = 0;
        partyLoop: for (String rawParty : parties) {
            StringTokenizer partyToken = new StringTokenizer(rawParty);
            int personCount = Integer.valueOf(partyToken.nextToken());
            for (int i=0; i<personCount; i++) {
                int partier = Integer.valueOf(partyToken.nextToken());
                if (factKnowers[partier]) {
                    continue partyLoop;
                }
            }
            lieCount++;
        }
        System.out.println(lieCount);
    }
}