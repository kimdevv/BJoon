import java.io.*;

public class QuadTree_1992 {

    private static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                array[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(divideAndConquer(0, 0, N));
    }

    private static String divideAndConquer(int startX, int startY, int length) {
        int color = array[startY][startX];
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                if (array[startY + i][startX + j] != color) {
                    int halfLength = length / 2;
                    return "(" + divideAndConquer(startX, startY, halfLength)
                        + divideAndConquer(startX + halfLength, startY, halfLength)
                        + divideAndConquer(startX, startY + halfLength, halfLength)
                        + divideAndConquer(startX + halfLength, startY + halfLength, halfLength)
                        + ")";
                }
            }
        }
        return color + "";
    }
}