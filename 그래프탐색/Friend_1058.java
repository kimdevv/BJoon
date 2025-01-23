import java.io.*;
import java.util.*;

public class Friend_1058 {
  private static int N; // 사람의 수
  private static List<Person> personList;
  private static BufferedReader bufferedReader;
  private static int[] friends;
  
  private static class Person {
    private char[] friendList;
    
    private Person(String rawFriendList) {
      friendList = rawFriendList.toCharArray();
    }
  }
  
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
    personList = new ArrayList<>();
    for (int i=0; i<N; i++) {
      String rawFriendList = bufferedReader.readLine();
      personList.add(new Person(rawFriendList));
    }
  }
  
  private static void process2Friend() {
    friends = new int[N];
    for (int i=0; i<N; i++) {
      Person nowPerson = personList.get(i);
      a: for (int j=0; j<N; j++) {
        if (i==j) {
          continue;
        }
        for (int k=0; k<N; k++) {
          if (i==k) {
            continue;
          }
          if (nowPerson.friendList[k] == 'Y') {
            if (j==k) {
              friends[i]++;
              continue a;
            } else {
              if (personList.get(k).friendList[j] == 'Y') {
                friends[i]++;
                continue a;
              }
            }
          }
        }
      }
    }
  }
  
  private static void outputResult() {
    System.out.println(Arrays.stream(friends).max().getAsInt());
  }
}
