import java.util.*;
import java.util.Stack;

public class ReverseWord_9093 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt(); // 테스트 케이스의 개수
		Stack stack = new Stack(); // 내가 구현한 스택!
		StringBuilder sb = new StringBuilder();
		
		String str;
		String[] str_list;
		
		for (int i=0; i<=T; i++) { // 테스트 케이스의 개수만큼
			str = scan.nextLine();
			str_list = str.split(" "); // 단어 별로 나눠서 배열에 담음
			
			for (int j=0; j<str_list.length; j++) { // 단어의 개수만큼
				if (sb.length() != 0) {
					sb.append(" ");					
				}
				for (int k=str_list[j].length()-1; k>=0; k--) { // 단어의 길이만큼
					stack.push(str_list[j].charAt(k)); // 단어의 맨 뒤 단어를 빼서 넣은 후
					sb.append((char)stack.pop()); // 바로 스택에서 pop하여 담는다.
				}
			}
		}
		System.out.println(sb);
	}

}
