import java.io.*;
import java.util.Stack;

public class Odeungkeunsu_17299 {

		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Stack<Integer> stack = new Stack<>(); // 비교 스택(숫자를 저장할 스택)
			Stack<Integer> stack2 = new Stack<>(); // 정답 스택
			StringBuilder sb = new StringBuilder();
			
			int N = Integer.parseInt(br.readLine());
			String[] A_list = br.readLine().split(" "); // 수를 나눠서 배열에 저장
			
			int max=Integer.parseInt(A_list[0]);
			for (int i=1; i<A_list.length; i++) { // 가장 큰 수를 찾는다
				if (max < Integer.parseInt(A_list[i])) {
					max = Integer.parseInt(A_list[i]);
				}
			}
			// 각 요소의 빈도 수(개수)를 저장할 배열
			int[] n_list = new int[max+1]; // 가장 큰 수까지 담을 수 있도록 배열을 만들어줌.
			
			// 각 요소들의 빈도 수를 n_list에 저장한다
			int n;
			for (int i=0; i<A_list.length; i++) {
				n = Integer.parseInt(A_list[i]);
				n_list[n]++;
			}
			
			for (int i=N-1; i>=0; i--) {
				n = Integer.parseInt(A_list[i]); // 맨 마지막 요소부터
				if (stack2.isEmpty()) { // 정답 스택이 비어있으면 (맨 마지막 요소라면)
					stack2.push(-1); // -1을 정답 스택에 저장한다
					stack.push(n); // 그리고 비교 스택에 자신을 넣어줌
				} else {
					while (!stack.isEmpty()) { // 계속 반복
						if (n_list[n] >= n_list[stack.peek()]) { // 앞 요소가 자신보다 빈도 수가 낮으면 제거한다
							stack.pop();  // 어차피 이 경우에는 그 이후로도 비교할 필요가 없기 때문.
						} else { // 나보다 빈도 수가 많은 요소를 만나면
							stack2.push(stack.peek()); // 내 정답 스택에 그 요소를 넣음
							stack.push(n); // 이제 나도 비교 스택에 들어간다
							break;
						}
					}
					if (stack.isEmpty()) { // 비교 스택을 다 돌았는데도 나보다 빈도 수 많은 요소가 없다면
						stack2.push(-1); // -1을 내 정답 스택에 추가한다
						stack.push(n); // 나를 정답 스택에 추가함
					}
				}
			}

			// 정답 스택 출력
			while (!stack2.isEmpty()) {
				sb.append(Integer.toString(stack2.pop()) + " ");
			}
			System.out.println(sb);
			
			br.close();
		}

	}
