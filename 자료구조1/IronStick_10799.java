import java.io.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class IronStick_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		
		String str = br.readLine();
		for (int i=0; i<str.length()-1; i++) {
			char c = str.charAt(i);
			if (c == '(') { // '('의 경우
				if (str.charAt(i+1) == ')') { // 레이저의 경우에는 스택에 넣으면 안 됨!
					cnt += stack.size(); // 지금 있는 막대기를 자르는 거니까 그만큼 ++한다
					i++; // 직후의 ')'는 스킵
				} else { // 레이저가 아니라 진짜 막대기의 시작점일 경우
					stack.push((int)str.charAt(i)); // 막대기가 시작됨
				}
			} else { // '('의 경우
				if (!stack.isEmpty()) { // 막대기가 존재한다면
					stack.pop(); // 막대기를 자른다
					cnt++; // 막대기가 잘리므로 막대기의 수가 하나 늘어남
				}
			}
		}
		// 위 for문에서는 맨 마지막 char을 검사하지 않았으므로 이제 검사해줌
		if (str.charAt(str.length()-2) == ')' && str.charAt(str.length()-1) == ')') {
			cnt++; // 맨 마지막이 ')'이며 레이저가 아닌 경우 막대기가 끝나므로 막대기의 수를 1개 올려줌
		}
		bw.write(Integer.toString(cnt));
		
		bw.close();
		br.close();
	}

}
