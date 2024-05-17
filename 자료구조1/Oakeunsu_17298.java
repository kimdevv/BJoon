import java.io.*;
import java.util.Stack;

public class Oakeunsu_17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>(); // 정답 스택
		Stack<Integer> stack2 = new Stack<>(); // 임시 스택
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int A;
		String[] A_list = br.readLine().split(" ");
		
		for (int i=N-1; i>=0; i--) {
			A = Integer.parseInt(A_list[i]);
			while (!stack2.isEmpty() && A >= stack2.peek()) { // 만약 제일 top의 요소가 A보다 작다면
				stack2.pop(); // 그 요소는 꺼내 버린다 (비교할 필요가 없고 앞으로도 그렇다)
			}
			if (stack2.isEmpty()) { // 다 비교했는데 더 비교할 요소가 없다면
				stack.push(-1); // 더 큰 요소가 없다는 뜻이므로 -1을 담는다.
			} else { // 나보다 큰 요소가 있다면
				stack.push(stack2.peek()); // 정답 스택에 그 요소를 추가한다
			}
			stack2.push(A); // 나를 임시 스택에 넣는다.
		}
		
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			sb.append(tmp + " ");
		}
		System.out.println(sb);
		br.close();
		bw.close();
	}

}
