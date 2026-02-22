import java.io.*;
import java.util.*;

public class TwoDimensionArrayOperation_17140 {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    List<List<Integer>> numbers = new ArrayList<>();
    for (int i=0; i<3; i++) {
      numbers.add(new ArrayList<>());
      st = new StringTokenizer(br.readLine(), " ");
      for (int j=0; j<3; j++) {
        numbers.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }
    
    int time = 0;
    while (time <= 100) {
      if (numbers.size() > r - 1 && numbers.get(0).size() > c - 1 && numbers.get(r - 1).get(c - 1) == k) {
        break;
      }
      numbers = relocation(numbers);
      time++;
    }
    
    System.out.println(time > 100 ? -1 : time);
    br.close();
  }
  
  private static List<List<Integer>> relocation(List<List<Integer>> numbers) {
    int rowSize = numbers.size();
    int columnSize = numbers.get(0).size();
    
    List<List<Integer>> newNumbers;
    if (rowSize >= columnSize) { // R 연산
      newNumbers = new ArrayList<>();
      int maxColumnSize = 0;
      for (int row=0; row<rowSize; row++) {
        // 개수 세기
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int column=0; column<columnSize; column++) {
          int number = numbers.get(row).get(column);
          if (number == 0) {
            continue;
          }
          countMap.merge(number, 1, Integer::sum);
        }
        
        // 개수 Map 정렬
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        Collections.sort(entryList, (e1, e2) -> {
          if (e1.getValue() == e2.getValue()) {
            return e1.getKey() - e2.getKey();
          } else {
            return e1.getValue() - e2.getValue();
          }
        });
        
        // 결과 Map에 넣기
        newNumbers.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : entryList) {
          newNumbers.get(row).add(entry.getKey());
          newNumbers.get(row).add(entry.getValue());
        }
        maxColumnSize = Math.max(maxColumnSize, newNumbers.get(row).size());
        maxColumnSize = Math.min(maxColumnSize, 100);
      }
      
      // 최대 개수에 맞게 0 채우기
      for (int i=0; i<rowSize; i++) {
        for (int j=newNumbers.get(i).size(); j<maxColumnSize; j++) {
          newNumbers.get(i).add(0);
        }
      }
    } else { // C 연산
      newNumbers = new ArrayList<>();
      List<List<Integer>> tempNumbers = new ArrayList<>(); // 열을 행으로 만들어 담아 둘 임시 리스트
      int maxRowSize = 0;
      for (int column=0; column<columnSize; column++) {
        // 개수 세기
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int row=0; row<rowSize; row++) {
          int number = numbers.get(row).get(column);
          if (number == 0) {
            continue;
          }
          countMap.merge(number, 1, Integer::sum);
        }
        
        // 개수 Map 정렬
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        Collections.sort(entryList, (e1, e2) -> {
          if (e1.getValue() == e2.getValue()) {
            return e1.getKey() - e2.getKey();
          } else {
            return e1.getValue() - e2.getValue();
          }
        });
        
        // 결과 Map에 넣기
        tempNumbers.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : entryList) {
          tempNumbers.get(column).add(entry.getKey());
          tempNumbers.get(column).add(entry.getValue());
        }
        maxRowSize = Math.max(maxRowSize, tempNumbers.get(column).size());
        maxRowSize = Math.min(maxRowSize, 100);
      }

      // tempNumbers를 newNumbers로 만들기 (행 -> 열)
      for (int i=0; i<maxRowSize; i++) {
        newNumbers.add(new ArrayList<>());
        for (int j=0; j<tempNumbers.size(); j++) {
          if (tempNumbers.get(j).size() > i) {
            newNumbers.get(i).add(tempNumbers.get(j).get(i));
          } else {
            newNumbers.get(i).add(0);
          }
        }
      }
    }
    
    return newNumbers;
  }
}
