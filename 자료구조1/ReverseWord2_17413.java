import java.io.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseWord2_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '<') { // '<'를 만나면 그대로 출력해야 함
				while (!stack.isEmpty()) { // 그 전에 스택에 문자가 넣어져 있다면
					int tmp_int = stack.pop(); // 다 출력해주고 시작한다.
					char tmp_c = (char)tmp_int;
					bw.write(tmp_c);
				}
				int j = i; // '<' 부터
				while (str.charAt(j) != '>') { // '>' 앞까지
					queue.offer((int)str.charAt(j)); // 다 큐에 넣는다
					j++;
				}
				queue.offer((int)str.charAt(j)); // '>'까지 큐에 넣음
				while (queue.size() != 0) { // 큐의 요소를 전부 빼서 출력한다
					int tmp_int = queue.poll(); // 어차피 FIFO니까 그대로 출력됨
					char tmp_c = (char)tmp_int;
					bw.write(tmp_c);
				}
				i = j; // '<' ~ '>'까지는 건너뛰어줌
				continue;
			}
			if (str.charAt(i) == ' ') { // 해당 문제가 공백일 경우
				while (!stack.isEmpty()) { // 앞에서 스택에 담았던 문자들을 출력
					int tmp_int = stack.pop(); // 스택은 LIFO니까 거꾸로 출력됨
					char tmp_c = (char)tmp_int;
					bw.write(tmp_c);
				}
				bw.write(" ");
			} else {
				stack.push((int)str.charAt(i)); // 공백이 아니면 스택에 담는다
			}
		}
		while (!stack.isEmpty()) { // for문을 다 돌면
			int tmp_int = stack.pop(); // 스택에 남은 문자들을 다 출력한다
			char tmp_c = (char)tmp_int;
			bw.write(tmp_c);
		}
		bw.close();
		br.close();
	}

}
