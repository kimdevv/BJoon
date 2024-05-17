import java.io.*;

public class FactorialFindZero_1676 {
	static int num5 = 0; // 해당 수가 가진 약수 5의 개수
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static int findZero(int N) {
		for (int i=1; i<=N; i++) { // 1부터 N까지 돌면서
			int tmp = i;
			
			// 사실 코드는 약수 5의 개수만 확인하면 된다.
			while (tmp % 5 == 0) { // 약수 중 5가 포함되는 수를 구한다
				num5++;
				tmp /= 5;
			}
		}
		
		return num5;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine());
		System.out.print(findZero(N));
		
		br.close();
	}
}
