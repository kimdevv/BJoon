import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class RoadOfNorthernCountry_1595 {
    private static final int maximumCities = 10_000;
    private static List<Road>[] roads;
    private static boolean[] isVisted;
    private static int max;

    public static void main(String[] args) throws IOException {
        initializeRoads();
        inputRoads();
        traverse();
        outputMax();
    }

    private static void initializeRoads() {
        roads = new List[maximumCities + 1];
        for (int i=0; i<=maximumCities; i++) {
            roads[i] = new ArrayList<>();
        }
    }

    private static void inputRoads() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String rawRoad;
        while((rawRoad = bufferedReader.readLine()) != null && !rawRoad.equals("")) {
            StringTokenizer road = new StringTokenizer(rawRoad, " ");
            int city1 = Integer.valueOf(road.nextToken());
            int city2 = Integer.valueOf(road.nextToken());
            int distance = Integer.valueOf(road.nextToken());
            roads[city1].add(new Road(city2, distance));
            roads[city2].add(new Road(city1, distance));
        }
    }

    private static void traverse() {
        max = 0;
        for (int i=1; i<=maximumCities; i++) {
            isVisted = new boolean[maximumCities + 1];
            dfs(i, 0);
        }
    }

    private static void dfs(int city, int retainedDistance) {
        isVisted[city] = true;
        for (Road road : roads[city]) {
            if (!isVisted[road.end]) {
                dfs(road.end, retainedDistance + road.distance);
            }
            max = Math.max(max, retainedDistance);
        }
    }

    private static void outputMax() {
        System.out.println(max);
    }

    private static class Road {
        private int end;
        private int distance;

        private Road(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}