import java.io.*;

public class MooGame_5904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(divideAndConquer(1, N));
    }

    private static char divideAndConquer(int level, int targetIndex) {
        if (level == 0) {
            return targetIndex == 1 ? 'm' : 'o';
        }

        if (targetIndex <= getLength(level - 1)) {
            return divideAndConquer(level-1, targetIndex);
        } else if (targetIndex <= getLength(level - 1) + 1 + level + 2) {
            return divideAndConquer(0, targetIndex - getLength(level - 1));
        } else if (targetIndex <= getLength(level)) {
            return divideAndConquer(level-1, targetIndex-(getLength(level - 1) + 1 + level + 2));
        } else {
            return divideAndConquer(level+1, targetIndex);
        }
    }

    private static int getLength(int level) {
        if (level == 0) {
            return 3;
        }
        return getLength(level - 1) + (1+level+2) + getLength(level - 1);
    }
}
