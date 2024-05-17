import java.io.*;
import java.util.StringTokenizer;

public class BaseConversion_11576 {
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = stoi(st.nextToken()); // 미래 세계에서 사용하는 진법
		int B = stoi(st.nextToken()); // 정이의 세계에서 사용하는 진법
		int m = stoi(br.readLine()); // A진법 수의 총 자릿수
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// A진법을 10진법으로 변경
		long dec = 0; // 반환할 변환된 10진법 수
		for (int i=0; i<m; i++) {
			// m번을 반복하며 그 자릿수만큼 A의 거듭제곱을 해당 자릿수의 수에 곱해서 dec에 더한다
			dec += stoi(st.nextToken()) * Math.pow(A, m-i-1);
		}
		
		String str = "";
		if (dec == 0) str = "0"; // 0이 입력되었다면 출력도 0
		
		// 10진법을 B진법으로 변경
		while (dec > 0) {
			str = Long.toString(dec%B) + " " + str;
			dec /= B;
		}
		
		System.out.print(str);
		
		br.close();
	}
}
