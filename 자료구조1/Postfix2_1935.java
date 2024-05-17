import java.io.*;
import java.util.Stack;

public class Postfix2_1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		
		int N = stoi(br.readLine());
		int[] n_list = new int[N]; // 각 알파벳에 대응되는 수를 담을 배열
		String str = br.readLine();
		
		for (int i=0; i<N;i ++) { // n_list에 각 알파벳과 대응되는 수를 담는다
			int ent = stoi(br.readLine());
			n_list[i] = ent;
		}
		
		double tmp_a, tmp_b; // 나중에 pop()해서 연산할 값들(피연산자)
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '+':
				tmp_b = stack.pop(); // 먼저 꺼낸 값이 오른쪽 피연산자에 들어간다
				tmp_a = stack.pop(); // 나중에 꺼낸 값이 왼쪽 피연산자에 들어간다
				stack.push(tmp_a + tmp_b);
				break;
			case '-':
				tmp_b = stack.pop();
				tmp_a = stack.pop();
				stack.push(tmp_a - tmp_b);
				break;
			case '*':
				tmp_b = stack.pop();
				tmp_a = stack.pop();
				stack.push(tmp_a * tmp_b);
				break;
			case '/':
				tmp_b = stack.pop();
				tmp_a = stack.pop();
				stack.push(tmp_a / tmp_b);
				break;
			default: // 연산자가 아니라 알파벳인 경우
				int num = (int)c - 65; // 그 알파벳에 해당하는 배열 인덱스를 구함
				stack.push((double)n_list[num]); // 그 인덱스의 배열 요소를 꺼내 스택에 담음
				break;
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
