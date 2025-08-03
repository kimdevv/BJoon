import java.io.*;
import java.util.*;

public class Quadrant_1891 {

    private static int d; // 사분면 조각 개수
    private static char[] firstLocationArray;
    private static Point firstLocationPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        d = Integer.parseInt(st.nextToken());
        String firstLocation = st.nextToken(); // 사분면 조각의 번호
        firstLocationArray = firstLocation.toCharArray();
        st = new StringTokenizer(br.readLine(), " ");
        long dx = Long.parseLong(st.nextToken()); // 좌우 이동 범위
        long dy = Long.parseLong(st.nextToken()); // 상하 이동 범위

        long firstArrayLength = 1L << d; // 2^d가 최초의 한 변 길이
        firstLocationPoint = findFirstLocationPoint(0, 0, 1, firstArrayLength); // 처음 위치를 찾는다
        firstLocationPoint.plusX(dx); // 처음 위치에서 이동시킨다
        firstLocationPoint.plusY(dy);

        if (firstLocationPoint.isOverRange(firstArrayLength - 1, firstArrayLength - 1)) { // 이동한 곳이 범위를 벗어났다면 -1을 출력한다
            System.out.println("-1");
            return;
        }

        System.out.println(findMovedLocation(0, 0, 1, firstArrayLength, new StringBuilder())); // 사분면 조각 번호를 찾는다
        br.close();
    }

    private static Point findFirstLocationPoint(long startX, long startY, int level, long arrayLength) {
        long halfLength = arrayLength / 2;
        if (level == d) {
            if (firstLocationArray[level - 1] == '1') { // 1사분면
                return new Point(startX + halfLength, startY);
            } else if (firstLocationArray[level - 1] == '2') { // 2사분면
                return new Point(startX, startY);
            } else if (firstLocationArray[level - 1] == '3') { // 3사분면
                return new Point(startX, startY + halfLength);
            } else { // 4사분면
                return new Point(startX + halfLength, startY + halfLength);
            }
        } else {
            if (firstLocationArray[level - 1] == '1') { // 1사분면
                return findFirstLocationPoint(startX + halfLength, startY, level + 1, halfLength);
            } else if (firstLocationArray[level - 1] == '2') { // 2사분면
                return findFirstLocationPoint(startX, startY, level + 1, halfLength);
            } else if (firstLocationArray[level - 1] == '3') { // 3사분면
                return findFirstLocationPoint(startX, startY + halfLength, level + 1, halfLength);
            } else { // 4사분면
                return findFirstLocationPoint(startX + halfLength, startY + halfLength, level + 1, halfLength);
            }
        }
    }

    private static StringBuilder findMovedLocation(long startX, long startY, int level, long arrayLength, StringBuilder result) {
        long halfLength = arrayLength / 2;
        long nextX = startX + halfLength;
        long nextY = startY + halfLength;
        if (level == d) {
            if (firstLocationPoint.x >= nextX && firstLocationPoint.y >= nextY) { // 4사분면
                result.append("4");
            } else if (firstLocationPoint.y >= nextY) { // 3사분면
                result.append("3");
            } else if (firstLocationPoint.x >= nextX) { // 1사분면
                result.append("1");
            } else { // 2사분면
                result.append("2");
            }
            return result;
        } else {
            if (firstLocationPoint.x >= nextX && firstLocationPoint.y >= nextY) { // 4사분면
                result.append("4");
                return findMovedLocation(nextX, nextY, level + 1, halfLength, result);
            } else if (firstLocationPoint.y >= nextY) { // 3사분면
                result.append("3");
                return findMovedLocation(startX, nextY, level + 1, halfLength, result);
            } else if (firstLocationPoint.x >= nextX) { // 1사분면
                result.append("1");
                return findMovedLocation(nextX, startY, level + 1, halfLength, result);
            } else { // 2사분면
                result.append("2");
                return findMovedLocation(startX, startY, level + 1, halfLength, result);
            }
        }
    }

    private static class Point {

        private long x;
        private long y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        private boolean isOverRange(long limitX, long limitY) {
            return this.x < 0 || this.x > limitX || this.y > limitY || this.y < 0;
        }

        private void plusX(long dx) {
            this.x += dx;
        }

        private void plusY(long dy) {
            this.y -= dy;
        }
    }
}