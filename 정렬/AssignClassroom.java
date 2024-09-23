import java.io.*;
import java.util.*;

public class AssignClassroom {

    public static class ClassRoom implements Comparable<ClassRoom> {
        int start;
        int end;

        ClassRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ClassRoom other) {
            if (this.start == other.start) {
                return other.end - this.end;
            } else {
                return other.start - this.start;
            }
        }
    }

    public static class Lesson implements Comparable<Lesson> {
        int start;
        int end;

        Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

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

        PriorityQueue<Lesson> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempStart = stoi(st.nextToken());
            int tempEnd = stoi(st.nextToken());

            pq.add(new Lesson(tempStart, tempEnd));
        }

        PriorityQueue<ClassRoom> roomPQ = new PriorityQueue<>();
        Lesson firstLesson = pq.poll();
        roomPQ.add(new ClassRoom(firstLesson.start, firstLesson.end));

        int count = 1;
        first: while(!pq.isEmpty()) {
            Lesson nowLesson = pq.poll();
            int nowStart = nowLesson.start;
            int nowEnd = nowLesson.end;

            ClassRoom nowRoom = roomPQ.poll();
            System.out.println("제일위    " + nowRoom.start + " " + nowRoom.end);
            if (nowEnd <= nowRoom.start) {
                nowRoom.start = nowStart;
                roomPQ.add(nowRoom);
                System.out.println("기존 변경    " + nowRoom.start + " " + nowRoom.end);
                System.out.println("변경후    " + roomPQ.peek().start + " " + roomPQ.peek().end);
                continue first;
            } else {
                roomPQ.add(new ClassRoom(nowStart, nowEnd));
                count++;
                System.out.println("새로 넣음     " + nowStart + " " + nowEnd);
                System.out.println("변경후    " + roomPQ.peek().start + " " + roomPQ.peek().end);
                continue first;
            }
        }

        System.out.println(roomPQ.peek().start);
        System.out.println(count);
    }
}