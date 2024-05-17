import java.io.*;
import java.util.Stack;

public class Postfix_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '(': // '('를 만나면
				stack.push(c); // 일단 스택에 넣는다
				break;
			case ')': // ')'를 만나면
				while (stack.peek() != '(') { // '('가 앞에 나온
					sb.append(stack.pop()); // 모든 연산자를 출력
				}
				stack.pop(); // '(' 제거
				break;
			case '*':
			case '/':
				// '*'나 '/'의 경우, 우선되므로 '+'나 '-'는 출력하지 않고 직전의 '*'와 '/'만 모두 출력한다
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					sb.append(stack.pop());
				}
				stack.push(c); // 자신을 담음
				break;
			case '+':
			case '-':
				// '+'나 '-'의 경우 우선순위가 가장 낮으니 직전의 연산자를 모두 출력한다
				// 그러나 '('가 나오면 멈춘다. 이건 위에서 case ')'에서 처리해야 함!
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.push(c);
				break;
			default: // 알파벳의 경우
				sb.append(c); // 그냥 그대로 출력한다
				break;
			}
		}
		
		// 반복문을 다 돌았는데 남은 연산자가 있다면 모두 출력한다
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.print(sb);
	}

}
