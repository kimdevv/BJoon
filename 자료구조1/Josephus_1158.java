import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class Josephus_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>(); // 자바에서 기본 제공되는 큐를 사용하려면 이렇게 해야 한다.
		
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int T = Integer.parseInt(str.split(" ")[1]);
		
		for (int i=1; i<=N; i++) {
			queue.offer(i); // 1부터 N까지 수를 모두 큐에 넣어줌.
		}

		bw.write("<");
		for (int i=0; i<N; i++) {
			if (i != 0) {
				bw.write(", ");
			}
			for (int j=0; j<T-1; j++) { // T-1번째 요소까지는
				queue.offer(queue.poll()); // 빼서 큐의 맨 뒤에 다시 넣는다
			}
			bw.write(Integer.toString(queue.poll())); // 그 상태에서 빼면 T번째 요소를 얻을 수 있음
			bw.flush(); // 쓴 후에는 bw를 정리하자
		}
		bw.write(">");
		bw.flush();
		
		br.close();
		bw.close();
	}

}
