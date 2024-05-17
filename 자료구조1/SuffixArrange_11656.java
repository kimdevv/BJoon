import java.io.*;
import java.util.Arrays;

public class SuffixArrange_11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String[] s_list = new String[str.length()];
		for (int i=0; i<str.length(); i++) { // 접미사를 다 s_list에 넣는다
			s_list[i] = str.substring(i, str.length());
		}
		Arrays.sort(s_list); // 배열을 정렬하는 메서드
		
		for (int i=0; i<s_list.length; i++) {
			sb.append(s_list[i] + "\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}

}
