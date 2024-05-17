import java.io.*;
import java.util.Arrays;

public class Goldbach_6588 {
	static final int MAX = 1000000;
	static boolean[] n_list = new boolean[MAX + 1]; // 소수인지 아닌지를 담을 배열. true = 소수, false = 소수 아님
	static StringBuilder sb = new StringBuilder();
	
	public static void goldbach(int num) {
		for (int i=3; i<=num/2; i+=2) { // 소수를 검사하는데 그 수는 홀수여야 하므로
			int a = num - i; // 두 번째 수는 해당 수 num에서 i를 뺀 값이다
			if (n_list[i] && n_list[a]) { // 두 수가 모두 소수라면
				sb.append(i).append(" + ").append(num-i); // 출력할 StringBuilder에 담는다
				return;
			}
		}
		
		// 만약 반복문을 다 돌았는데도 홀수인 두 소수 짝을 찾지 못했다면
		sb.setLength(0);
		sb.append("Goldbach's conjection is wrong."); // 골드바흐의 추측은 틀린 것이 된다
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
		// 여기까지가 1000000까지 모든 수가 소수인지 합성수인지 나타내는 배열인 n_list를 구성하는 과정!
		
		int N;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			sb.append(N + " = ");
			goldbach(N);
			System.out.println(sb);
			sb.setLength(0);
		}
		
		br.close();
	}

}
