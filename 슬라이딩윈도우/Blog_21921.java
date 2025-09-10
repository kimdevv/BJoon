import java.io.*;
import java.util.*;

public class Blog_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 블로그를 시작하고 지난 일수
        int x = Integer.parseInt(st.nextToken()); // 알고자 하는 연속 일수

        int[] counts = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i< n; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i=0; i< x; i++) {
            result += counts[i];
        }

        int max = result;
        int maxCount = 1;
        for (int i= x; i< n; i++) {
            result -= counts[i - x];
            result += counts[i];

            if (result == max) {
                maxCount++;
            } else if (result > max) {
                max = result;
                maxCount = 1;
            }
        }

        if (result == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(maxCount);
        }
        br.close();
    }
}