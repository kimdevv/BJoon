import java.util.*;
import java.util.Stack;

public class StackSequence_1874 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int top=0;
		int num;
		boolean pass = true; // 이게 false가 되면 NO를 출력하게 할 거임
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<n; i++) {
			num = scan.nextInt();
			if (top < num) { // 기존에 넣었던 수들 보다 더 큰 수가 들어오면
				for (int j=top+1; j<=num; j++) { // 그 수까지 스택에 넣은 후
					stack.push(j);
					sb.append("+\n");
				}
				top = num; // 우리가 넣은 수 중 가장 큰 수?를 기록해준다.
			}
			if (stack.peek() == num) { // 맨 마지막 수가 우리가 도출해야 할 수가 맞는지 확인
				stack.pop(); // 맞다면 pop
				sb.append("-\n");
			} else { // 아니라면 스택 수열 불가.
				pass = false;
			}
		}
		
		System.out.print(pass ? sb : "NO");
	}

}
