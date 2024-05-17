import java.io.*;

public class NumberOfAlphabet_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] n_list = new int[122 - 97 + 1]; // 'z' - 'a' + 1개의 빈도 수 저장 배열
		String S = br.readLine();
		
		for (int i=0; i<S.length(); i++) { // 알파벳 별로 빈도 수를 저장한다
			int tmp = (int)S.charAt(i) - 97; // 자신의 알파벳 ASCII - 97(a)번 인덱스의 배열에!
			n_list[tmp]++; // 빈도 수를 1 올려줌
		}
		
		for (int i=0; i<n_list.length; i++) {
			sb.append(Integer.toString(n_list[i]) + " ");
		}
		
		System.out.print(sb);
	}

}
