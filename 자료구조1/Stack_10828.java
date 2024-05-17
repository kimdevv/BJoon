import java.util.*;

class Stack {
	private static int[] list; // 스택을 구현할 배열
	private static int size = 0; // 스택에 담긴 요소의 수
	
	public Stack(int N) {
		list = new int[N];
	}
	
	public int size() {
		return size;
	}
	
	public void push(int e) {
		list[size] = e; // 배열의 맨 마지막에 요소를 담음
		size++; // 요소의 수를 올려줌
	}
	
	public int pop() {
		if (size == 0) { // 요소가 없을 경우
			return -1;
		} else {
			int tmp = list[size-1];
			list[size-1] = 0;
			size--;
			return tmp;
		}
	}
	
	public int empty() {
		return size == 0 ? 1 : 0; // 스택에 요소가 없으면 1을, 있으면 0을 반환한다. 
	}
	
	public int top() {
		return size != 0 ? list[size-1] : -1; 
	}
	
}

public class Stack_10828 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int num_command = scan.nextInt();
		Stack stack = new Stack(num_command);
		
		scan.nextLine();
		for (int i=0; i<num_command; i++) {
			String str = scan.nextLine();
			String str1;
			String str2;
			int param = 0;
			
			String[] str_list = str.split(" ");
			if (str_list.length == 2) {
				str1 = str.split(" ")[0];
				str2 = str.split(" ")[1];
				param = Integer.parseInt(str2);
			} else {
				str1 = str.split(" ")[0];
			}
			
			switch(str1) {
			case "push" :
				stack.push(param);
				break;
			case "pop" :
				sb.append(stack.pop()).append("\n");
				break;
			case "empty" :
				sb.append(stack.empty()).append("\n");
				break;
			case "size" :
				sb.append(stack.size()).append("\n");
				break;
			case "top" :
				sb.append(stack.top()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
