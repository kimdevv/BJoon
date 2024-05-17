import java.io.*;

public class LCM_1934 {
	
	// 유클리드 호제법으로 구하는 gcd, lcm
	
	// a와 b를 나눈 나머지가 0이 될 때 작은 수가 gcd이다
	public static int gcd(int a, int b) {
		while (b > 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
	
	// 유클리드 호제법으로 lcm을 구하려면 a, b를 곱한 값에서 gcd를 나누면 된다
	public static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = stoi(br.readLine());
		
		int a, b;
		for (int i=0; i<T; i++) {
			String str = br.readLine();
			a = stoi(str.split(" ")[0]);
			b = stoi(str.split(" ")[1]);
			
			sb.append(lcm(a, b)).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
