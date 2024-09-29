/*
    1477번인데 못 풀었다 ㅜㅜ
 */

import java.io.*;
import java.util.*;

public class BuildingRest {
    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = stoi(stringTokenizer.nextToken()); // 현재 휴게소의 개수
        int M = stoi(stringTokenizer.nextToken()); // 더 지으려고 하는 휴게소의 개수
        int L = stoi(stringTokenizer.nextToken()); // 고속도로의 길이

        PriorityQueue<Integer> inputPQ = new PriorityQueue<>(); // 오름차순으로 입력받음
        if (N!=0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i=0; i<N; i++) {
                int number = stoi(stringTokenizer.nextToken());
                inputPQ.add(number);
            }
        }
        inputPQ.add(L);

        int now = 0;
        int[] checkArray = new int[L+1];
        PriorityQueue<Integer> distancePQ = new PriorityQueue<>(Collections.reverseOrder()); // 거리 차이는 내림차순으로 저장
        for (int i=0; i<=N; i++) {
            int rest = inputPQ.poll();
            int distance = rest - now;
            now = rest;
            checkArray[distance]++;

            distancePQ.add(distance);
        }

        for (int i=0; i<M; i++) {
            int distance = distancePQ.poll();
            System.out.println(distance + " " + distance/2);
            if (distance%2 == 1) {
                distancePQ.add(distance/2);
                distancePQ.add(distance/2+1);
            } else {
                distancePQ.add(distance/2);
                distancePQ.add(distance/2);
            }
        }

        System.out.println(distancePQ.peek());
    }
}