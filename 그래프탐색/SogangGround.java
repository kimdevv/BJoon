import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class SogangGround {
    public static class Route implements Comparable<Route> {
        int end;
        int item;
        int distance;

        Route(int end, int item, int distance) {
            this.end = end;
            this.item = item;
            this.distance = distance;
        }

        @Override
        public int compareTo(Route other) {
            return other.item - this.item;
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken()); // 지역의 개수
        int m = stoi(st.nextToken()); // 수색 범위
        int r = stoi(st.nextToken()); // 길의 개수

        st = new StringTokenizer(br.readLine());
        int[] itemCount = new int[n+1]; // 각 아이템의 개수 배열
        for (int i=1; i<itemCount.length; i++) {
            itemCount[i] = stoi(st.nextToken());
        }

        List<Route>[] routeList = new List[n+1];
        for (int i = 0; i <= n; i++) {
            routeList[i] = new ArrayList<>();  // 각 인덱스에 새로운 ArrayList 할당
        }
        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = stoi(st.nextToken());
            int vertex2 = stoi(st.nextToken());
            int distance = stoi(st.nextToken());

            // 하나의 간선으로 두 노드 모두 갈 수 있다
            routeList[vertex1].add(new Route(vertex2, itemCount[vertex2], distance));
            routeList[vertex2].add(new Route(vertex1, itemCount[vertex1], distance));
        }

        int max = 0;
        PriorityQueue<Route> pq = new PriorityQueue<>();
        for (int k=1; k<=n; k++) {
            // 누적 아이템 수
            int[] saveItem = new int[n+1];
            saveItem[k] = itemCount[k];

            // 누적 거리 수
            int[] saveDistance = new int[n+1];
            Arrays.fill(saveDistance, 100_000);
            saveDistance[k] = 0;

            boolean[] isVisited = new boolean[n+1];

            int nowSaveItem = 0;
            pq.add(new Route(k, itemCount[k], 0));
            while (!pq.isEmpty()) {
                Route nowRoute = pq.poll();
                int nowLocation = nowRoute.end;
                int nowItem = nowRoute.item;
                int nowDistance = nowRoute.distance;

                if (saveDistance[nowLocation] < nowDistance || saveItem[nowLocation] > nowItem || nowDistance > m) {
                    continue;
                }

                saveItem[nowLocation] = nowItem;
                if (isVisited[nowLocation]) {
                    // 방문했던 지역이라면
                    nowSaveItem -= saveItem[nowLocation];
                } else {
                    // 방문하지 않았던 지역이라면
                    isVisited[nowLocation] = true;
                }
                nowSaveItem += saveItem[nowLocation];

                saveDistance[nowLocation] = nowDistance;

                if (max <= nowSaveItem) {
                    max = nowSaveItem;
                }

                for (int i=0; i<routeList[nowLocation].size(); i++) {
                    Route nextRoute = routeList[nowLocation].get(i);
                    int nextLocation = nextRoute.end;
                    int nextItem = nextRoute.item;
                    int nextDistance = nextRoute.distance;

                    // 아이템이 더 많아지는 경우
                    if (saveItem[nextLocation] < nowItem + nextItem) {
                        // PQ에 담는다.
                        pq.add(new Route(nextLocation, nextItem, nowDistance+nextDistance));
                    }
                }
            }
        }

        System.out.println(max);
    }
}
