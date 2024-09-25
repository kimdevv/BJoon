import java.io.*;
import java.util.*;

public class CupRamen {
    public static class Homework {
        int deadline;
        int ramen;

        Homework(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }
    }

    public static int stoi(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(bufferedReader.readLine()); // 숙제의 개수
        // 숙제를 저장할 우선순위 큐
        PriorityQueue<Homework> homeworkPQ = new PriorityQueue<>(new Comparator<Homework>() {
            @Override
            public int compare(Homework h1, Homework h2) {
                if (h1.deadline == h2.deadline) {
                    return h2.ramen - h1.ramen;
                } else {
                    return h1.deadline - h2.deadline;
                }
            }
        });

        // 숙제는 데드라인은 오름차순으로 정렬해서 담음
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int tempDeadline = stoi(st.nextToken());
            int tempRamen = stoi(st.nextToken());

            homeworkPQ.add(new Homework(tempDeadline, tempRamen));
        }

        // 선택될 숙제를 저장할 우선순위 큐
        // 컵라면 수 오름차순으로 저장한다.
        PriorityQueue<Homework> selectedPQ = new PriorityQueue<>(new Comparator<Homework>() {
            @Override
            public int compare(Homework h1, Homework h2) {
                if (h1.ramen == h2.ramen) {
                    return h1.deadline - h2.deadline;
                } else {
                    return h1.ramen - h2.ramen;
                }
            }
        });

        // 우선순위 큐 초기화 (가장 컵라면 개수 큰 숙제를 담음)
        Homework firstHomework = homeworkPQ.poll();
        selectedPQ.add(firstHomework);

        int ramenCount = firstHomework.ramen; // 저장할 컵라면 개수
        int time = 0; // 데드라인을 0부터 1씩 늘려가면서
        while (!homeworkPQ.isEmpty()) { // 데드라인이 낮은 숙제부터 뽑아서 확인
            Homework nowHomework = homeworkPQ.poll();
            int nowDeadline = nowHomework.deadline;
            int nowRamen = nowHomework.ramen;

            // 일단 PQ에 숙제를 더한다
            selectedPQ.add(nowHomework);
            ramenCount += nowRamen;

            // 현재 숙제의 데드라인이 현재 데드라인보다 높다면
            if (nowDeadline > time) {
                time = nowDeadline; // 현재 시간을 그 데드라인으로 늘림
            }
            if (selectedPQ.size() > time) { // 현재 PQ의 크기가 현재 데드라인보다 크다면
                ramenCount -= selectedPQ.poll().ramen; // 하나를 뺀다
            }
        }

        System.out.println(ramenCount);
    }
}