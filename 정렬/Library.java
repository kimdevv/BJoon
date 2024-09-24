import java.io.*;
import java.util.*;

public class Library {
  public static int stoi(String str) {
    return Integer.parseInt(str);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = stoi(st.nextToken()); // 책의 개수
    int M = stoi(st.nextToken()); // 한 번에 들 수 있는 책의 개수
    
    // 양의정수 음의정수 나눠서 PQ에 입력받음
    PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      int temp = stoi(st.nextToken());
      if (temp > 0) {
        plusPQ.add(temp);
      } else {
        minusPQ.add(temp);
      }
    }
    
    int step = 0; // 출력할 걸음 수
    
    if (plusPQ.size() == 0) { // 음수만 있는 경우
      // 가장 긴 거리는 왕복할 필요 없이 책 M개 들고 마지막에 한 번만 가면 된다
      int minusMax = Math.abs(minusPQ.peek());
      step += minusMax;
      for (int i=0; i<M; i++) {
        if (minusPQ.isEmpty()) {
          break;
        }
        minusPQ.poll();
      }
      
      // 절댓값(거리)이 가장 큰 수를 M개 간격으로 더함
      while(minusPQ.size()>0) {
        int tempMinus = Math.abs(minusPQ.peek());
        step += (tempMinus + tempMinus);
        
        for (int i=0; i<M; i++) {
          if (minusPQ.isEmpty()) {
            break;
          }
          minusPQ.poll();
        }
      }
      
      System.out.println(step);
    } else if (minusPQ.size() == 0) { // 양수만 있는 경우
      // 가장 긴 거리는 왕복할 필요 없이 책 M개 들고 마지막에 한 번만 가면 된다
      int plusMax = plusPQ.peek();
      step += plusMax;
      for (int i=0; i<M; i++) {
        if (plusPQ.isEmpty()) {
          break;
        }
        plusPQ.poll();
      }
      
      // 절댓값(거리)이 가장 큰 수를 M개 간격으로 더함
      while(plusPQ.size()>0) {
        int tempPlus = plusPQ.peek();
        step += (tempPlus + tempPlus);
        
        for (int i=0; i<M; i++) {
          if (plusPQ.isEmpty()) {
            break;
          }
          plusPQ.poll();
        }
      }
      
      System.out.println(step);
    } else { // 양수, 음수 둘 다 있는 경우
      // 절댓값이 가장 큰 수를 찾음
      // 가장 긴 거리는 왕복할 필요 없이 책 M개 들고 마지막에 한 번만 가면 된다
      int plusMax = plusPQ.peek();
      int minusMax = Math.abs(minusPQ.peek());
      if (plusMax >= minusMax) {
        step += plusMax;
        for (int i=0; i<M; i++) {
          if (plusPQ.isEmpty()) {
            break;
          }
          plusPQ.poll();
        }
      } else if (plusMax < minusMax) {
        step += minusMax;
        for (int i=0; i<M; i++) {
          if (minusPQ.isEmpty()) {
            break;
          }
          minusPQ.poll();
        }
      }
      
      // 절댓값(거리)이 가장 큰 수를 M개 간격으로 더함
      while(plusPQ.size()>0 && minusPQ.size()>0) {
        int tempPlus = plusPQ.peek();
        int tempMinus = Math.abs(minusPQ.peek());
        step += (tempPlus + tempPlus);
        step += (tempMinus + tempMinus);
        
        for (int i=0; i<M; i++) {
          if (plusPQ.isEmpty()) {
            break;
          }
          plusPQ.poll();
        }
        for (int i=0; i<M; i++) {
          if (minusPQ.isEmpty()) {
            break;
          }
          minusPQ.poll();
        }
      }
      
      while(plusPQ.size()>0) {
        int tempPlus = plusPQ.peek();
        step += (tempPlus + tempPlus);
        
        for (int i=0; i<M; i++) {
          if (plusPQ.isEmpty()) {
            break;
          }
          plusPQ.poll();
        }
      }
      
      while(minusPQ.size()>0) {
        int tempMinus = Math.abs(minusPQ.peek());
        step += (tempMinus + tempMinus);
        
        for (int i=0; i<M; i++) {
          if (minusPQ.isEmpty()) {
            break;
          }
          minusPQ.poll();
        }
      }
      System.out.println(step);
    }
  }
}
