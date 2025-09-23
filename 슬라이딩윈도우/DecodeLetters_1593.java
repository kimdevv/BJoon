import java.io.*;
import java.util.*;

public class DecodeLetters_1593 {

    private static int wLength;
    private static int sLength;
    private static String W;
    private static String S;
    private static int[] chars;
    private static int[] answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        wLength = Integer.parseInt(st.nextToken());
        sLength = Integer.parseInt(st.nextToken());

        W = br.readLine();
        S = br.readLine();
        S += S;

        initializeAnswers();

        int result = 0;
        chars = new int[58]; // A to z
        for (int i=0; i<wLength; i++) {
            char currentChar = S.charAt(i);
            chars[currentChar - 'A']++;
        }
        if (checkSubstring()) {
            result++;
        }

        for (int i=wLength; i<sLength; i++) {
            char currentChar = S.charAt(i);
            chars[currentChar - 'A']++;
            char previousChar = S.charAt(i - wLength);
            chars[previousChar - 'A']--;
            if (checkSubstring()) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void initializeAnswers() {
        answers = new int[58]; // A to Z
        for (int i = 0; i < wLength; i++) {
            char currentChar = W.charAt(i);
            answers[currentChar - 'A']++;
        }
    }

    private static boolean checkSubstring() {
        for (int i=0; i<wLength; i++) {
            if (chars[W.charAt(i) - 'A'] != answers[W.charAt(i) - 'A']) {
                return false;
            }
        }
        return true;
    }
}