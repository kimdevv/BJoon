import java.io.*;
import java.util.Arrays;

public class GoldbachPartition_17103 {
	static final int MAX = 1000000;
	static boolean[] n_list = new boolean[MAX + 1]; // 소수인지 아닌지를 담을 배열. true = 소수, false = 소수 아님
	static StringBuilder sb = new StringBuilder();
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static int goldbach(int num) {
		if (num == 4) {
			return 1;
		}
		
		int cnt = 0;
		for (int i=3; i<=num/2; i+=2) { // 소수를 검사하는데 그 수는 홀수여야 하므로
			int a = num - i; // 두 번째 수는 해당 수 num에서 i를 뺀 값이다
			if (n_list[i] && n_list[a]) { // 두 수가 모두 소수라면
				cnt++; // cnt에 1을 더한다
			}
		}
		
		return cnt; // 소수 쌍의 개수를 반환
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(n_list, true);
		n_list[0] = false;
		n_list[1] = false;
		for (int i=2; i<=Math.sqrt(1000000); i++) {
			if (n_list[i]) {
				for (int j=2; j*i<=1000000; j++) {
					n_list[i*j] = false; // 합성수를 찾으면 그 배수를 모두 합성수로 표기한다
				}
			}
		}
		
		int T = stoi(br.readLine());
		for (int i=0; i<T; i++) {
			int N = stoi(br.readLine());
			sb.append(goldbach(N)).append("\n");
		}
		System.out.print(sb);
	
		br.close();
	}
}
