import java.io.*;

public class AnalyzeString_10820 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str;
		while ((str = br.readLine()) != null) { // EOF 처리를 위해 줄이 비어있으면 반복을 멈추도록 한다
			sb.setLength(0); // StringBuilder 초기화
			int[] n_list = {0, 0, 0, 0}; // 줄 마다 개수를 세야 하므로 빈도 수 초기화
			
			for (int i=0; i<str.length(); i++) {
				int c_num = (int)str.charAt(i);
				if (c_num == (int)' ') { // 공백일 경우
					n_list[3]++;
					continue;
				} else if ((int)'A' <= c_num && c_num <= (int)'Z') { // 대문자일 경우
					n_list[1]++;
					continue;
				} else if ((int)'a' <= c_num && c_num <= (int)'z') { // 소문자일 경우
					n_list[0]++;
					continue;
				} else {
					n_list[2]++; // 숫자일 경우
					continue;
				}
			}
			
			for (int i=0; i<n_list.length; i++) {
				sb.append(Integer.toString(n_list[i]));
				sb.append(" ");
			}
			System.out.println(sb);
		}
	}

}
