import java.io.*;

public class MakePalindrome_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] counts = new int[(int)'Z' + 1];
        for (int i=0; i<line.length(); i++) {
            counts[line.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder();
        boolean isMiddleExists = false;
        char middleChar = '0';
        for (int i=(int)'A'; i<=(int)'Z'; i++) {
            int count = counts[i];
            while (count > 0) {
                if (count == 1) {
                    if (isMiddleExists == true) {
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    } else {
                        isMiddleExists = true;
                        middleChar = (char)i;
                        count -= 2;
                    }
                } else {
                    sb.append((char)i);
                    count -= 2;
                }
            }
        }


        System.out.print(sb);
        System.out.print(isMiddleExists ? (char)middleChar : "");
        System.out.print(sb.reverse());
    }
}