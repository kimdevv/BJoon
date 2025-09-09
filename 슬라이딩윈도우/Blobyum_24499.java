import java.io.*;
import java.util.*;

public class Blobyum_24499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 애플파이의 개수
        int k = Integer.parseInt(st.nextToken()); // 먹으려는 애플파이의 개수

        int[] pies = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i< n; i++) {
            pies[i] = Integer.parseInt(st.nextToken());
        }

        int now = 0;
        for (int i=0; i< k; i++) {
            now += pies[i];
        }

        int max = now;
        for (int i= k; i< n; i++) {
            now -= pies[i- k];
            now += pies[i];
            max = Math.max(max, now);
        }

        for (int i= k; i>0; i--) {
            now -= pies[n - i];
            now += pies[k - i];
            max = Math.max(max, now);
        }

        System.out.println(max);
        br.close();
    }
}