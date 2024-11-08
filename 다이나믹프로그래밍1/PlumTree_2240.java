import java.io.*;
import java.util.*;

public class PlumTree_2240 {
    private static int T; // 자두가 떨어지는 시간
    private static int W; // 사람이 최대로 움직일 수 있는 거리

    private static ArrayList<Integer> plumArray = new ArrayList<>();
    private static int[] dpArray;

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        inputTW(); // T와 W를 입력받는다.
        inputPlum(); // 자두가 떨어지는 위치를 입력받는다.
        setDP(); // dp 배열을 완성한다.

        System.out.println(dpArray[T]);
        System.out.println(Arrays.toString(dpArray));
    }

    private static void inputTW() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        T = Integer.parseInt(stringTokenizer.nextToken());
        W = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void inputPlum() throws IOException {
        for (int i=0; i<T; i++) {
            int plumLocation = Integer.parseInt(bufferedReader.readLine());
            plumArray.add(plumLocation);
        }
    }

    private static void setDP() {
        dpArray = new int[T+1];

        int nowLocation = 1;
        int lastOtherPlum = 0; // 다른 나무의 마지막 개수
        for (int i=1; i<=T; i++) {
            int plumLocation = plumArray.get(i-1);

        }
    }
}