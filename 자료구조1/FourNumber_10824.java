import java.io.*;

public class FourNumber_10824 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] n_list = br.readLine().split(" ");
		
		// 숫자를 붙임
		String numAB = n_list[0] + n_list[1];
		String numCD = n_list[2] + n_list[3];
		
		// 붙인 숫자를 long으로 변환해서 더한 후 sb에 담음
		sb.append(stol(numAB) + stol(numCD));
		
		System.out.print(sb);
		
		br.close();
	}
	
	public static long stol(String s) {
		return Long.parseLong(s);
	}

}
