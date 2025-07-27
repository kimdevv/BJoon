import java.io.*;

public class Star10_2447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int power = findPowerOfThree(N);
        System.out.println(divideAndConquer(power));
        br.close();
    }

    private static int findPowerOfThree(int N) {
        int power = 1;
        while (Math.pow(3, power) != N) {
            power++;
        }
        return power;
    }

    private static String divideAndConquer(int level) {
        if (level == 1) {
            return "***\n* *\n***";
        }
        String previous = divideAndConquer(level - 1);
        String[] splitted = previous.split("\n");
        int unit = (int) Math.pow(3, level - 1);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<unit; i++) { // 윗줄
            for (int j=0; j<3; j++) {
                sb.append(splitted[i]);
            }
            sb.append("\n");
        }
        for (int i=unit; i<unit*2; i++) { // 가운데줄
            sb.append(splitted[i - unit]);
            for (int j=0; j<unit; j++) {
                sb.append(" ");
            }
            sb.append(splitted[i - unit]);
            sb.append("\n");
        }
        for (int i=unit*2; i<unit*3; i++) { // 밑줄
            for (int j=0; j<3; j++) {
                sb.append(splitted[i - unit*2]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}