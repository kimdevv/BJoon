import java.io.*;

public class GCDandLCM_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int a = Integer.parseInt(str.split(" ")[0]);
		int b = Integer.parseInt(str.split(" ")[1]);
		
		int GCD=0; // 최대공약수
		int LCM=0; // 최소공배수
		
		// 최대공약수 구하기
		if (a > b) { // b가 더 작다면
			for (int i=b; i>=0; i--) { // b부터 1씩 감소하면서
				if (a%i==0 && b%i ==0) { // a와 b 동시에 약수가 되는 수를 찾으면
					GCD = i; // GCD에 저장한다
					break;
				}
			}
		} else { // a가 더 작다면
			for (int i=a; i>=0; i--) { // a부터 1씩 감소하면서
				if (a%i==0 && b%i ==0) { // a와 b 동시에 약수가 되는 수를 찾으면
					GCD = i; // GCD에 저장한다
					break;
				}
			}
		}
		
		// 최소공배수 구하기
		if (a > b) { // b가 더 작다면
			int i = 1; // 1부터 차례로 곱하면서
			while (true) {
				if ((b*i)%a == 0) { // a의 배수가 되는 수를 처음 찾으면
					LCM = b*i; // LCM에 저장한다
					break;
				}
				i++;
			}
		} else { // a가 더 작다면
			int i = 1; // 1부터 차례로 곱하면서
			while (true) {
				if ((a*i)%b == 0) { // b의 배수가 되는 수를 처음 찾으면
					LCM = a*i; // LCM에 저장한다
					break;
				}
				i++;
			}
		}

		System.out.println(GCD);
		System.out.print(LCM);
		
		br.close();
	}

}
