import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortingCard_1715 {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        int N = stoi(br.readLine());
        int[] array = new int[N];
        for (int i=0; i<N; i++) {
            pQ.offer(stoi(br.readLine()));
        }

        int sum = 0;
        for (int i=0; i<N-1; i++) {
            int tmp = pQ.poll() + pQ.poll();
            sum += tmp;
            pQ.offer(tmp);
        }

        System.out.println(sum);
        
        /*
        10 50 60 70 100
        60 130 100
        160 130
        290
        
        10 60 80 400         10 60 80 400
        70 80 400            0 70 80 400
        150 400              0 0 150 400
        550                  0 0 0 550 
        */
    }
}