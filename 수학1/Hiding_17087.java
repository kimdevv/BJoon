import java.io.*;
import java.util.StringTokenizer;

public class Hiding_17087 {
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static int GCD(int n1, int n2) {
		if (n1 % n2 == 0) return n2;
		
		return GCD(n2, n1%n2);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = stoi(st.nextToken()); // 동생의 개수
		int S = stoi(st.nextToken()); // 수빈이의 현재 위치
		
		int[] s_list = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			s_list[i] = stoi(st.nextToken());
			s_list[i] = Math.abs(s_list[i]-S);
		} // 각 배열에 수빈이의 현재 위치에서 동생들의 위치를 뺀 값의 절댓값(거리)을 저장한다.
		
		int min = s_list[0]; // 첫 번째 거리 하나 가지고
		
		// 그 거리와 다른 거리들의 최대공약수 중 가장 작은 값을 찾은 후 반환
		for (int i=1; i<s_list.length; i++) {
			int tmp;
			tmp = GCD(min, s_list[i]);
			if (min > tmp) {
				min = tmp;
			}
		}
		System.out.println(min);
		
		br.close();
	}
}
