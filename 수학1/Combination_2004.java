import java.io.*;
import java.util.StringTokenizer;

public class Combination_2004 {	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}


	public static int findZeroInCombination5(int N) {
		int num5 = 0;

		/*
		 * N에 5가 몇 번 곱해져있는지 본다. (5로 나눈 몫으로 구함)
		 * 0~4까지는 0
		 * 5~9까지는 1
		 * 10~14까지는 2
		 * 15~24까지는 3
		 * 25~29까지는 6 (25는 5의 제곱이므로 2가 더해진다)
		 * ...
		 */
		while (N >= 5) {
			num5 += N/5;
			N /= 5;
		}
		
		return num5;
	}
	
	public static int findZeroInCombination2(int N) {
		int num2 = 0;
		
		/*
		 * 5와 같은 방법으로 N에 2가 몇 번 곱해져있는지 본다.
		 */
		while (N >= 2) {
			num2 += N/2;
			N /= 2;
		}
		
		return num2;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());

		// 이 경우 약수 2의 개수도 세어 줘야 한다. 5보다 2의 개수가 더 작아질 수도 있기 때문
		// nCm은 n! / (n-m)!m!이므로
		int n5 = findZeroInCombination5(n) - findZeroInCombination5(n-m) - findZeroInCombination5(m);
		int n2 = findZeroInCombination2(n) - findZeroInCombination2(n-m) - findZeroInCombination2(m);
		
		sb.append(Math.min(n5, n2));
		System.out.print(sb);
		
		br.close();
	}
}
