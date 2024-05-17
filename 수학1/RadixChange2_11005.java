import java.io.*;
import java.util.StringTokenizer;

public class RadixChange2_11005 {
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = stoi(st.nextToken());
		int B = stoi(st.nextToken());
		
		// B로 계속 나눠서 나머지를 sb에 담는다.
		while (N > 0) {
			int inp = N % B;
			if (inp >= 10) { // 나머지가 10 이상이라면
				sb.append((char)(inp - 10 + 'A')); // 그에 해당하는 알파벳을 담는다
			} else { // 나머지가 10 이하라면
				sb.append(inp); // 그 수를 담는다
			}
			N /= B;
		}
		
		System.out.print(sb.reverse());
		
		br.close();
	}
}