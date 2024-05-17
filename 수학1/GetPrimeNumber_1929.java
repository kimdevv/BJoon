import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GetPrimeNumber_1929 {
	
	// 소수인지 아닌지를 담을 배열
	static boolean[] n_list; // true = 소수, false = 소수 아님
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static void isPrime(int num, int N) {
		if (num == 0 || num == 1) { // 0이나 1은 소수가 아님
			n_list[num] = false;
		} else { // 2 이상의 수에 대해서는
			for (int i=2; num*i <= N; i++) { // 그 배수를 전부 합성수로 판단한다
				n_list[num*i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// split(" ") 말고 StringTokenizer이라는 클래스가 있었네...
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = stoi(st.nextToken());
		int N = stoi(st.nextToken());
		n_list = new boolean[N+1];
		
		Arrays.fill(n_list, true);
		n_list[0] = false;
		n_list[1] = false;
		
		for (int i=2; i<=Math.sqrt(N); i++) { // 2부터 루트N까지 돌면서
			if (n_list[i] == false) continue; // 이미 합성수로 판단된 수는 제외하고 
			isPrime(i, N); // 그 수가 합성수인지 판단하고, 그렇다면 배수를 전부 합성수로 만든다
		}
		
		for (int i=M; i<=N; i++) {
			if (n_list[i] == true) {
				sb.append(i).append("\n");
			}
		}

		System.out.print(sb);
		
		br.close();
	}

}
