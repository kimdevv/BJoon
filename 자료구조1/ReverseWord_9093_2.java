import java.util.*;
import java.util.Stack;

public class ReverseWord_9093_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt(); // 테스트 케이스의 개수
		Stack<Integer> stack = new Stack<>(); // 자바에서 기본 제공하는 스택 클래스
		
		String str;
		
		for (int i=0; i<=T; i++) {
			str = scan.nextLine();
			
			for (int j=0; j<str.length(); j++) {
				if (str.charAt(j) == ' ') {
					while (!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				} else {
					stack.push((int)str.charAt(j));
				}
			}
			
			while (!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
			
			System.out.println();
		}
	}

}
