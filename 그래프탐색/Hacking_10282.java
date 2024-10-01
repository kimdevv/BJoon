import java.io.*;
import java.util.*;

public class Hacking_10282 {
    public static class Route implements Comparable<Route> {
        int end;
        int distance;

        Route(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Route other) {
            return this.distance - other.distance;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = stoi(br.readLine());
        while (testCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken()); // 컴퓨터의 개수
            int d = stoi(st.nextToken()); // 의존성의 개수
            int c = stoi(st.nextToken()); // 해킹당한 컴퓨터의 번호

            int[] distanceArray = new int[n+1];
            Arrays.fill(distanceArray, Integer.MAX_VALUE);
            distanceArray[c] = 0;

            // 간선 저장하는 배열
            List<Route>[] routeArray = new List[n+1];
            for (int i=0; i<=n; i++) {
                routeArray[i] = new ArrayList<>();
            }

            for (int i=0; i<d; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = stoi(st2.nextToken()); // 컴퓨터 a가
                int b = stoi(st2.nextToken()); // 컴퓨터 b를 의존
                int s = stoi(st2.nextToken()); // s초 후에 감염 (distance)

                Route newRoute = new Route(a, s);
                routeArray[b].add(newRoute);
            }

            PriorityQueue<Route> pq = new PriorityQueue<>();
            pq.add(new Route(c, 0));
            while (!pq.isEmpty()) {
                Route nowRoute = pq.poll();
                int nowComputer = nowRoute.end;
                int nowDistance = nowRoute.distance;

                // 이미 더 적은 거리로 갱신된 컴퓨터라면 그냥 넘어감
                if (nowDistance > distanceArray[nowComputer]) {
                    continue;
                }

                // 그 컴퓨터와 연결된 간선들을 확인
                for (Route nextRoute : routeArray[nowComputer]) {
                    int nextComputer = nextRoute.end;
                    int nextDistance = nowDistance + nextRoute.distance;

                    if (nextDistance < distanceArray[nextComputer]) {
                        distanceArray[nextComputer] = nextDistance;
                        pq.add(new Route(nextComputer, nextDistance));
                    }
                }
            }

            int count = 0;
            int maxTime = 0;
            for (int i=1; i<=n; i++) {
                if (distanceArray[i] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, distanceArray[i]);
                }
            }
            System.out.println(count + " " + maxTime);
        }
    }
}