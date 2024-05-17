import java.io.*;

public class MinusBinary_2089 {
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		if (N==0) {
			sb.append(0);
		} else {
			// -2로 계속 나눠서 나머지의 절댓값을 저장한다.
			while (N != 0) {
				int rem = N % (-2);
				if (rem == -1) {
					sb.append(1);
					N = N / (-2) + 1; // N이 음수였을 땐 나눈 후 1을 더해줘야 제대로 나눠짐
				} else {
					sb.append(rem);
					N /= (-2);
				}
			}
		}
		if (N%(-2) != 0) {
			sb.append(Math.abs(N%(-2)));
		}
		
		System.out.print(sb.reverse());
		
		br.close();
	}
}
