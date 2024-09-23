import java.io.*;
import java.util.*;

public class AssignClassroom {

    // 강의실 객체
    public static class ClassRoom implements Comparable<ClassRoom> {
        int start;
        int end;

        ClassRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 강의실은 시작 시간 기준으로 내림차순 정렬한다.
        @Override
        public int compareTo(ClassRoom other) {
            if (this.start == other.start) {
                return other.end - this.end;
            } else {
                return other.start - this.start;
            }
        }
    }

    // 수업 객체
    public static class Lesson implements Comparable<Lesson> {
        int start;
        int end;

        Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 수업은 끝 시간을 기준으로 내림차순 정렬한다.
        @Override
        public int compareTo(Lesson other) {
            if (this.end == other.end) {
                return other.start - this.start;
            } else {
                return other.end - this.end;
            }
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine()); // 수업의 개수

        // 수업 정보들을 모두 가져와서 끝 시간 내림차순으로 정렬해서 PQ에 넣음.
        PriorityQueue<Lesson> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempStart = stoi(st.nextToken());
            int tempEnd = stoi(st.nextToken());

            pq.add(new Lesson(tempStart, tempEnd));
        }

        PriorityQueue<ClassRoom> roomPQ = new PriorityQueue<>(); // 강의실을 저장할 PQ
        Lesson firstLesson = pq.poll(); // 첫 번째 수업을 강의실에 넣고 PQ를 초기화
        roomPQ.add(new ClassRoom(firstLesson.start, firstLesson.end));

        int count = 1;
        while(!pq.isEmpty()) {
            // 끝 시간 기준으로 내림차순으로 하나씩 수업을 가져옴
            Lesson nowLesson = pq.poll();
            int nowStart = nowLesson.start;
            int nowEnd = nowLesson.end;

            // 시작 시간이 제일 느린 수업을 하나 꺼내서
            ClassRoom nowRoom = roomPQ.poll();
            if (nowEnd <= nowRoom.start) { // 그 수업 앞에 현재 수업을 시작할 수 있다면
                nowRoom.start = nowStart; // 그 강의실을 그대로 사용한다.
                roomPQ.add(nowRoom);
            } else { // 그 수업 앞에 현재 수업을 시작할 수 없다면 (현재 존재하는 강의실로는 지금 수업을 시작할 수 없다면)
                roomPQ.add(nowRoom); // 새로운 강의실을 추가한다.
                roomPQ.add(new ClassRoom(nowStart, nowEnd));
                count++;
            }
        }

        System.out.println(count);
    }
}