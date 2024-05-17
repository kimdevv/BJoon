import java.io.*;

class Deque {
	static int[] list;
	static int n;
	static int pot = 0; // 덱에 담긴 요소의 개수
	
	public Deque(int N) {
		this.n = N;
		this.list = new int[N];
	}
	
	public void push_front(int e) {
		if (pot == n) { // 배열이 꽉 찼을 경우 늘려주는 과정
			int[] tmp_list = new int[2*n];
			for (int i=0; i<n; i++) {
				tmp_list[i] = list[i];
			}
			n *= 2;
			list = tmp_list;
		}
		if (pot > 0) { // 이미 요소가 담겨 있을 경우에는 list[0]을 비워줘야 하므로
			for (int i=pot-1; i>=0; i--) { // 요소들을 한 칸씩 뒤로 밀어준다
				list[i+1] = list[i]; // list[0]은 list[1]로 가고... 뒤의 요소들도 반복
			}
		}
		list[0] = e; // 그럼 list[0]이 자리가 생기므로 그 자리에 e를 넣기만 하면 된다
		pot++; // 요소의 개수가 하나 늘어남
	}
	
	public void push_back(int e) {
		if (pot == n) { // 배열이 꽉 찼을 경우 늘려주는 과정
			int[] tmp_list = new int[2*n];
			for (int i=0; i<n; i++) {
				tmp_list[i] = list[i];
			}
			n *= 2;
			list = tmp_list;
		}
		list[pot] = e; // 맨 뒤에 e를 추가해주기만 하면 된다
		pot++; // 요소의 개수가 하나 늘어남
	}
	
	public int pop_front() {
		if (pot == 0) {
			return -1;
		} else {
			int res = list[0]; // 반환할 요소 임시 저장
			for (int i=1; i<pot; i++) { // 맨 앞의 요소가 하나 빠지므로
				list[i-1] = list[i]; // 요소들을 하나씩 앞으로 당겨준다
			}
			pot--; // 요소의 개수가 하나 줄어듦
			return res;
		}
	}
	
	public int pop_back() {
		if (pot == 0) {
			return -1;
		} else {
			int res = list[pot-1];
			list[pot-1] = 0; // pop_front()와는 달리 맨 마지막 요소만 빼주면 된다
			pot--; // 요소의 개수가 하나 줄어듦
			return res;
		}
	}
	
	public int size() {
		return pot;
	}
	
	public int empty() {
		return pot == 0 ? 1 : 0;
	}
	
	public int front() {
		return pot == 0 ? -1 : list[0];
	}
	
	public int back() {
		return pot == 0 ? -1 : list[pot-1];
	}
}

public class Deque_10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str, com;
		int param;
		Deque deque = new Deque(N);
		
		for (int i=0; i<N; i++) {
			str = br.readLine();
			com = str.split(" ")[0];
			
			switch(com) {
			case "push_front" :
				param = Integer.parseInt(str.split(" ")[1]);
				deque.push_front(param);
				break;
			case "push_back" :
				param = Integer.parseInt(str.split(" ")[1]);
				deque.push_back(param);
				break;
			case "pop_front" :
				bw.write(Integer.toString(deque.pop_front()));
				bw.newLine();
				break;
			case "pop_back" :
				bw.write(Integer.toString(deque.pop_back()));
				bw.newLine();
				break;
			case "size" :
				bw.write(Integer.toString(deque.size()));
				bw.newLine();
				break;
			case "empty" :
				bw.write(Integer.toString(deque.empty()));
				bw.newLine();
				break;
			case "front" :
				bw.write(Integer.toString(deque.front()));
				bw.newLine();
				break;
			case "back" :
				bw.write(Integer.toString(deque.back()));
				bw.newLine();
				break;
			}
			bw.flush();
		}
		bw.close();
		br.close();
	}

}
