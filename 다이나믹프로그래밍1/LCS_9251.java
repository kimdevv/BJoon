import java.io.*;
import java.util.*;

public class LCS_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] stringArray = new String[2];
        stringArray[0] = bufferedReader.readLine();
        stringArray[1] = bufferedReader.readLine();

        int longer = stringArray[0].length() >= stringArray[1].length() ? 0 : 1;
        int shorter = longer == 0 ? 1 : 0;
        int[] dpArray = new int[stringArray[longer].length() + 1];

        int lastIndex = 0;
        for (int i=0; i<stringArray[shorter].length(); i++) {
            char findChar = stringArray[shorter].charAt(i);
            for (int j=1; j<stringArray[longer].length()+1; j++) {
                int findIndex = stringArray[longer].indexOf(findChar, lastIndex);

            }
            System.out.println(Arrays.toString(dpArray));
        }

        System.out.println(dpArray[dpArray.length-1]);
    }
}