import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int k;
    private static int[] conveyor;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        conveyor = new int[n * 2]; // 컨베이어 벨트 위 n 개의 내구도
        robot = new boolean[n]; // 컨베어이 벨트 위의 로봇 유무

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n * 2; i++) {
            conveyor[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;
        while (k > 0) {
            level++;
            moveConveyor();
            moveRobot();
            robotUp();
        }

        System.out.print(level);
        reader.close();
    }

    // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    private static void moveConveyor() {
        int length = conveyor.length - 1;

        int last = conveyor[length];
        for (int i = length; i > 0; i--) {
            conveyor[i] = conveyor[i - 1];
        }
        conveyor[0] = last;

        for (int i = robot.length - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = robot[n - 1] = false;
    }

    // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    private static void moveRobot() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && conveyor[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                if (conveyor[i + 1] == 1) k--;
                conveyor[i + 1]--;
            }
        }
        robot[n - 1] = false;
    }

    // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    private static void robotUp() {
        if (!robot[0] && conveyor[0] > 0) {
            robot[0] = true;
            if (conveyor[0] == 1) k--;
            conveyor[0]--;
        }
    }
}