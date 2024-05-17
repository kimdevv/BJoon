import java.io.*;
import java.util.StringTokenizer;

public class SumOfGCD_9613 {
	static long sum;
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static int SumOfGCD(int n1, int n2) {
		if (n1==0 || n2==0) return 0;
		
		// 호제법으로 GCD를 구한다.
		if (n1 % n2 != 0) {
			return SumOfGCD(n2, n1%n2);
		} else {
			return n2;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = stoi(br.readLine());
		for (int i=0; i<t; i++) {
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = stoi(st.nextToken());
			int[] n_list = new int[n]; // n개 만큼의 배열 생성
			for (int j=0; j<n; j++) { // n만큼 반복
				n_list[j] = stoi(st.nextToken()); // 배열에 수를 할당
			}
			
			// 모든 두 쌍의 경우의 수의 GCD를 구해 static 변수인 sum에 누적.
			for (int j=0; j<n_list.length; j++) {
				for (int k=j+1; k<n_list.length; k++) {
					sum += SumOfGCD(n_list[j], n_list[k]);
				}
			}
			System.out.println(sum);
		}
		
		br.close();
	}
}
