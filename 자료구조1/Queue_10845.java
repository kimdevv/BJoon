import java.io.*;

class Queue {
	static int[] list;
	static int n;
	static int pot = 0; // 큐에 담긴 요소의 개수
	
	public Queue(int N) {
		n = N;
		list = new int[n];
	}
	
	public static void push(int X) {
		if (pot == n) { // 큐가 가득 차면
			int[] tmp_list = new int[2*n]; // 기존의 2배만큼의 크기로 옮겨준다.
			for (int i=0; i<n; i++) {
				tmp_list[i] = list[i];
			}
			list = tmp_list;
			n *= 2;
		}
		list[pot] = X; // 요소를 큐에 담은 후
		pot++; // 요소의 개수를 하나 늘려준다
	}
	
	public static int pop() {
		int res = -1;
		if (pot != 0) {
			res = list[0]; // 제일 첫 요소 (반환할 값)
			for (int i=1; i<n; i++) { // 요소들을 한 칸씩 앞으로 당겨준다.
				list[i-1] = list[i];
			}
			list[n-1] = 0; // 맨 마지막 요소는 없앤다 (어차피 list[n-2]으로 옮겨졌으므로)
			pot--; // 요소의 개수를 하나 줄인다
		}
		return res;
	}
	
	public static int size() {
		return pot;
	}
	
	public static int empty() {
		return pot == 0 ? 1 : 0;
	}
	
	public static int front() {
		return pot != 0 ? list[0] : -1;
	}
	
	public static int back() {
		return pot != 0 ? list[pot-1] : -1;
	}
}

public class Queue_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Queue queue = new Queue(n);
		
		String str, com;
		int param;
		for (int j=0; j<n; j++) {
			str = br.readLine(); // 명령어를 읽어들임
			com = str.split(" ")[0]; // 어떤 명령어인지 판별
			switch(com) {
			case "push":
				param = Integer.parseInt(str.split(" ")[1]); // push 명령어라면 매개변수를 추가로 읽어들임
				queue.push(param);
				break;
			case "pop":
				bw.write(Integer.toString(queue.pop())); // bw는 문자열만 출력할 수 있으므로 int를 문자열으로 바꿔서 출력
				bw.newLine();
				break;
			case "size":
				bw.write(Integer.toString(queue.size()));
				bw.newLine();
				break;
			case "empty":
				bw.write(Integer.toString(queue.empty()));
				bw.newLine();
				break;
			case "front":
				bw.write(Integer.toString(queue.front()));
				bw.newLine();
				break;
			case "back":
				bw.write(Integer.toString(queue.back()));
				bw.newLine();
				break;
			}
			bw.flush(); // 한 번 bw를 사용한 후에는 버퍼를 바로 비워주자
		}
		
		bw.close();
		br.close();
	}

}
