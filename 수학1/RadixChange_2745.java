import java.io.*;
import java.util.StringTokenizer;

public class RadixChange_2745 {
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String N = st.nextToken();
		int B = stoi(st.nextToken());
		
		int res = 0; // 최종적으로 반환할 10진수 값
		
		for (int i=0; i<N.length(); i++) {
			char c = N.charAt(i);
			int tmp;
			if (c >= 'A') { // 그 단어가 알파벳인 경우
				tmp = (int)c - 'A' + 10; // 그 알파벳을 해당하는 수로 바꿔준다 ('A'부터 10)
			} else { // 알파벳이 아닌 경우 (숫자인 경우)
				tmp = c - '0'; // char로 되어있는 그 수를 int로 바꿔준다
			}
			tmp *= Math.pow(B, N.length()-i-1); // 자릿수 만큼 B의 거듭제곱으로 곱한 값을
			res += tmp; // 반환할 값에 더한다
		}
		
		System.out.print(res);
		
		
		br.close();
	}
}
