import java.io.*;
import java.util.*;

public class Main {
    private static List<Character>[] gears;
    private static boolean[] check;
    private static final int LEFT = 6;
    private static final int RIGHT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        gears = new List[4];
        check = new boolean[4];

        for (int i = 0; i < 4; i++) {
            gears[i] = new ArrayList<>();
            char[] list = reader.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gears[i].add(list[j]);
            }
        }

        int k = Integer.parseInt(reader.readLine());

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());

            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            check[gearNum] = true;
            turn(gearNum, dir);
            check[gearNum] = false;
        }

        System.out.print(getTotalScore());
    }

    private static void turn(int gearNum, int dir) {
        checkLeftGear(gearNum, dir);
        checkRightGear(gearNum, dir);

        if (dir == 1) clockwise(gears[gearNum]);
        else counterclockwise(gears[gearNum]);
    }

    private static void checkLeftGear(int gearNum, int dir) {
        int leftGearNum = gearNum - 1;
        if (leftGearNum >= 0 && !check[leftGearNum] && gears[leftGearNum].get(RIGHT) != gears[gearNum].get(LEFT)) {
            check[leftGearNum] = true;
            turn(leftGearNum, -dir);
            check[leftGearNum] = false;
        }
    }

    private static void checkRightGear(int gearNum, int dir) {
        int rightGearNum = gearNum + 1;
        if (rightGearNum < 4 && !check[rightGearNum] && gears[gearNum].get(RIGHT) != gears[rightGearNum].get(LEFT)) {
            check[rightGearNum] = true;
            turn(rightGearNum, -dir);
            check[rightGearNum] = false;
        }
    }

    private static void clockwise(List<Character> gear) {
        gear.add(0, gear.remove(7));
    }

    private static void counterclockwise(List<Character> gear) {
        gear.add(gear.remove(0));
    }

    private static int getTotalScore() {
        int totalScore = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].get(0) == '1') {
                totalScore += Math.pow(2, i);
            }
        }
        return totalScore;
    }
}