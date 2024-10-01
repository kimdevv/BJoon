import java.io.*;
import java.util.*;

public class SortingNumber2_2751 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<count; i++) {
            pq.add(scanner.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll() + "\n");
        }

        System.out.println(sb);
    }
}