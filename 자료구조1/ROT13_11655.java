import java.io.*;

public class ROT13_11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if ('A' <= c && c <= 'Z') { // 대문자인 경우
				int tmp = (int)c + 13; // 13번째 뒤의 문자를 뽑음
				if (tmp > 'Z') { // 그러나 Z를 넘어가는 경우
					tmp -= 26; // A부터 다시 돌린다
				}
				sb.append((char)tmp);
			} else if ('a' <= c && c <= 'z') { // 소문자인 경우
				int tmp = (int)c + 13; // 13번째 뒤의 문자를 뽑음
				if (tmp > 'z') { // 그러나 z를 넘어가는 경우
					tmp -= 26; // a부터 다시 돌린다
				}
				sb.append((char)tmp);
			} else {
				sb.append(c);
			}
		}
		System.out.print(sb);
		
		br.close();
	}

}
