import java.io.*;
import java.util.*;

public class Friend_1058 {
  private static int N; // 사람의 수
  private static char[][] friends; // 친구 리스트
  private static boolean[][] twoFriends; // 2-친구 수
    private static BufferedReader bufferedReader;
  
  public static void main(String[] args) throws IOException {
    initializeBufferedReader();
    inputN();
    inputPerson();
    process2Friend();
    outputResult();
  }
  
  private static void initializeBufferedReader() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  }
  
  private static void inputN() throws IOException {
    N = Integer.parseInt(bufferedReader.readLine());
  }
  
  private static void inputPerson() throws IOException {
    friends = new char[N][N];
    for (int i=0; i<N; i++) {
      String rawFriendList = bufferedReader.readLine();
      friends[i] = rawFriendList.toCharArray();
    }
  }
  
  private static void process2Friend() {
    twoFriends = new boolean[N][N];
    for (int i=0; i<N; i++) { // 시작
      for (int j=0; j<N; j++) { // 끝
        for (int k=0; k<N; k++) { // 거쳐가기
          if (friends[i][j] == 'Y' || (friends[i][k] == 'Y' && friends[k][j] == 'Y')) {
            twoFriends[i][j] = true;
            break;
          }
        }
      }
    }
  }
  
  private static void outputResult() {
    int max = Integer.MIN_VALUE;
    for (int i=0; i<N; i++) {
      int temp = 0;
      for (int k=0; k<N; k++) {
        if (twoFriends[i][k]) {
          temp++;
        }
      }
      max = Math.max(max, temp);
    }
    System.out.println(max == 0 ? max : max-1);
  }
}
