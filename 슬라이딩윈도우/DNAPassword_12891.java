import java.io.*;
import java.util.*;

public class DNAPassword_12891 {

    private static final int[] counts = {0,  0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
        int p = Integer.parseInt(st.nextToken()); // DNA 부분문자열의 길이

        String dna = br.readLine(); // DNA 문자열

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<4; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int[] currentCounts = {0, 0, 0, 0};
        for (int i=0; i< p; i++) {
            count(dna.charAt(i), currentCounts);
        }

        result += checkCounts(currentCounts);
        for (int i= p; i< s; i++) {
            char previousCharacter = dna.charAt(i - p);
            downCount(previousCharacter, currentCounts);
            char nextCharacter = dna.charAt(i);
            count(nextCharacter, currentCounts);
            result += checkCounts(currentCounts);
        }

        System.out.println(result);
        br.close();
    }

    private static void count(char word, int[] currentCounts) {
        if (word == 'A') {
            currentCounts[0]++;
        } else if (word == 'C') {
            currentCounts[1]++;
        } else if (word == 'G') {
            currentCounts[2]++;
        } else if (word == 'T') {
            currentCounts[3]++;
        }
    }

    private static void downCount(char word, int[] currentCounts) {
        if (word == 'A') {
            currentCounts[0]--;
        } else if (word == 'C') {
            currentCounts[1]--;
        } else if (word == 'G') {
            currentCounts[2]--;
        } else if (word == 'T') {
            currentCounts[3]--;
        }
    }

    private static int checkCounts(int[] currentCounts) {
        if (currentCounts[0] >= counts[0] && currentCounts[1] >= counts[1] && currentCounts[2] >= counts[2] && currentCounts[3] >= counts[3]) {
            return 1;
        }
        return 0;
    }
}