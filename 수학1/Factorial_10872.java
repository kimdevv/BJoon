import java.io.*;

public class Factorial_10872 {
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static int factorial(int n) {
		if (n==0) {
			return 1;
		}
		if (n==1) {
			return n;
		} else {
			return n * factorial(n-1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		sb.append(factorial(N));
		System.out.print(sb);
		
		br.close();
	}
}
