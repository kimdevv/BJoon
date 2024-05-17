import java.io.*;

public class Remainer_10430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] n_list = br.readLine().split(" ");
		sb.append( Integer.toString((stoi(n_list[0])+stoi(n_list[1])) % stoi(n_list[2])) + "\n" );
		sb.append( ((stoi(n_list[0])%stoi(n_list[2])) + (stoi(n_list[1])%stoi(n_list[2]))) % stoi(n_list[2]) + "\n");
		sb.append( (stoi(n_list[0])*stoi(n_list[1])) % stoi(n_list[2]) + "\n");
		sb.append( ((stoi(n_list[0])%stoi(n_list[2])) * (stoi(n_list[1])%stoi(n_list[2]))) % stoi(n_list[2]) + "\n");
		
		System.out.print(sb);
		
		br.close();
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
