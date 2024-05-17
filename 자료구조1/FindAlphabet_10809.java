import java.io.*;

public class FindAlphabet_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 알파벳 별로 첫 인덱스를 담을 배열 생성
		int[] n_list = new int[(int)'z' - (int)'a' + 1];
		
		for (int i=0; i<n_list.length; i++) {
			n_list[i] = -1; // 존재하지 않는다면 -1을 담는다
		}
		
		String S = br.readLine();
		for (int i=0; i<S.length(); i++) {
			char c = S.charAt(i);
			int c_num = (int)c - (int)'a';
			if (n_list[c_num] == -1) { // 첫 인덱스가 배열에 담기지 않은 알파벳이라면
				n_list[c_num] = i; // 배열에 첫 인덱스를 담는다
			}
		}
		
		for (int i=0; i<n_list.length; i++) {
			sb.append(Integer.toString(n_list[i]));
			sb.append(" ");
		}
		
		System.out.print(sb);
		
	}

}
