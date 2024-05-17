import java.io.*;

public class PrimeNumber_1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = stoi(br.readLine());
		int cnt = N; // 소수의 개수. N개에서 합성수를 만날 때마다 1씩 감소시킬 것.
		String[] n_list = br.readLine().split(" ");
		
		for (int i=0; i<N; i++) {
			int n = stoi(n_list[i]);
			
			if (n == 1) { // 1은 소수가 아니므로
				cnt--; // 개수를 하나 감소시킨다
			} else { // 1이 아닌 수를 만나면
				for (int j=2; j<n; j++) {
					if (n%j == 0) { // 그 수가 만약 합성수라면
						cnt--; // 소수의 개수를 하나 감소시킨다
						break;
					}
				}
			}
		}
		
		sb.append(cnt);
		System.out.print(sb);
		
		br.close();
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
