import java.io.*;
import java.util.*;

public class DragonAndDungeon_16434 {
    static long[][] dungeon;
    static long maxHP, attack;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 던전을 이루는 방의 개수
        attack = Long.parseLong(stringTokenizer.nextToken()); // 공격력

        dungeon = new long[N][3];
        for (int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            dungeon[i][0] = Long.parseLong(stringTokenizer.nextToken()); // 몬스터(1) or 포션(2)
            dungeon[i][1] = Long.parseLong(stringTokenizer.nextToken()); // 공격력
            dungeon[i][2] = Long.parseLong(stringTokenizer.nextToken()); // 생명력
        }

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2; // maxHP가 이 값이면 클리어 가능한가?

            if (canClearDungeon(mid, attack)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left == 0 ? 1 : left;
    }


    public static boolean canClearDungeon(long maxHP, long attack) {
        long curHP = maxHP;
        for (int i=0; i<dungeon.length; i++) {
            if (dungeon[i][0] == 1) { // 몬스터의 경우
                long mobAttack = dungeon[i][1];
                long mobHP = dungeon[i][2];

                // 한 턴 진행
                long minTurn;
                if (mobHP % attack > 0) {
                    minTurn = mobHP / attack;
                } else {
                    minTurn = mobHP / attack - 1;
                }
                curHP -= (mobAttack * minTurn);
                if (curHP <= 0) {
                    return false;
                }

            } else { // 포션의 경우
                if (curHP+dungeon[i][2] > maxHP) {
                    curHP = maxHP;
                } else {
                    curHP += dungeon[i][2];
                }
                attack += dungeon[i][1];
            }
        }
        return true;
    }
}
