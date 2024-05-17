import java.io.*;
import java.util.Arrays;

public class Factorization_11653 {
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		
		final int MAX = N;
		boolean[] n_list = new boolean[N + 1]; // 소수인지 아닌지를 담을 배열. true = 소수, false = 소수 아님
		
		Arrays.fill(n_list, true);
		n_list[0] = false;
		n_list[1] = false;
		for (int i=2; i<=Math.sqrt(MAX); i++) { // 2부터 돌면서
			if (n_list[i]) { // 만약 그 수가 소수라면
				for (int j=2; j*i<=MAX; j++) {
					n_list[i*j] = false; // 그 수의 배수는 모두 합성수이다
				}
			}
		}
		// 여기까지가 1000000까지 모든 수가 소수인지 합성수인지 나타내는 배열인 n_list를 구성하는 과정!
		
		for (int i=2; i<=N/2; i++) { // 2부터 돌면서
			if (n_list[i]) { // 소수인 수에 한해
				while (N%i==0) { // 그 수로 N이 나눠진다면
					sb.append(i).append("\n"); // StringBuilder에 그 수를 추가한다
					N /= i;
				}
			}
		}
		
		if (N != 1) sb.append(N); // 남은 값도 StringBuilder에 추가해준다
		
		System.out.print(sb);
		
		br.close();
	}
}
