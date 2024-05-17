import java.io.*;
import java.util.Stack;

public class Editor_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		String str = br.readLine(); // br으로 읽는 방법.
		String str_com;
		char command;
		char param;
		int n = Integer.parseInt(br.readLine()); // br에는 Int를 읽는 메서드가 없어서, 문자열로 읽은 후 변환해줘야 한다.

		for (char c : str.toCharArray()) {
			stack.push((int)c); // 읽은 문자열을 전부 스택에 넣음
		}
		
		for (int i=0; i<n; i++) {
			str_com = br.readLine();
			command = str_com.charAt(0);
			
			switch (command) {
			// 우리가 사용할 곳은 stack이고, stack2는 커서를 이동하는 데에만 사용할 거다!
			case 'L': // 왼쪽으로 커서를 한 칸 옮기는 경우이므로
				if (!stack.isEmpty()) {
					stack2.push(stack.pop()); // 맨 마지막 문자를 stack2로 옮긴다.
				}
				break;
			case 'D': // 오른쪽으로 커서를 한 칸 옮기는 경우이므로
				if (!stack2.isEmpty()) {
					stack.push(stack2.pop()); // stack2에서 가지고 있던 원래의 요소를 하나 가져온다.
				}
				break;
			case 'B': // 커서 앞의 문자를 지우는 경우이므로
				if (!stack.isEmpty()) {
					stack.pop(); // 어차피 커서는 stack의 맨 마지막을 가리키고 있으니까 하나만 pop해주면 된다.
				}
				break;
			case 'P': // 커서 앞에 문자를 추가하는 경우도 'B'와 같이
				param = str_com.charAt(2);
				stack.push((int)param); // 커서는 stack의 맨 마지막을 가리키므로 그 상태에서 바로 push하면 된다.
				// 어차피 이후의 요소들은 전부 stack2에 담겨있으니까.
				break;
			}
		}
		
		while (!stack.isEmpty()) { // 이제 stack에 있는 모든 요소들을
			stack2.push(stack.pop()); // stack2로 옮겨준다. 흩어져있는 문자들을 하나로 합치는 과정!
		}
		while (!stack2.isEmpty()) {
			int a = stack2.pop();
			char c = (char)a;
			bw.write(c); // bw를 통해 stack2에서 출력해준다.
		}
		
		// br과 bw는 사용 후에는 꼭! 닫아준다.
		bw.close();
		br.close();
	}

}