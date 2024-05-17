import java.io.*;

public class MakeTo1_1463 {

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = stoi(br.readLine());

		int[] dp = new int[X+1];
		dp[0] = 0;
		dp[1] = 0;

		for (int i=2; i<=X; i++) {
			dp[i] = dp[i-1] + 1;
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		System.out.print(dp[X]);

		br.close();
	}
}
