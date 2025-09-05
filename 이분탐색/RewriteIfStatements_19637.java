import java.io.*;
import java.util.*;

public class RewriteIfStatements_19637 {

    private static Title[] titles; // 칭호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 칭호의 개수
        int n = Integer.parseInt(st.nextToken());
        // 캐릭터들의 개수
        int m = Integer.parseInt(st.nextToken());

        titles = new Title[n];
        for (int i=0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = new Title(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i< m; i++) {
            int character = Integer.parseInt(br.readLine());
            result.append(findTitle(character)).append("\n");
        }

        System.out.println(result);
        br.close();
    }

    private static String findTitle(int character) {
        int left = 0;
        int right = titles.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (character <= titles[mid].limit) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return titles[left].name;
    }

    private static class Title {

        private final String name;
        private final int limit;

        Title(String name, int limit) {
            this.name = name;
            this.limit = limit;
        }
    }
}