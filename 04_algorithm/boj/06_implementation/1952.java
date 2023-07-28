import java.util.*;
import java.io.*;

public class Main {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static boolean[][] visit;
    private static int m, n;
    private static int turningCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        visit = new boolean[m][n];

        move(0, 0, 0, 0);
        System.out.println(turningCount - 4);
    }

    private static void move(int x, int y, int direction, int movingFailCount) {
        if (movingFailCount == 4) return;
        visit[x][y] = true;

        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
            if (!visit[nx][ny]) {
                move(nx, ny, direction, 0);
                return;
            }
        }

        turningCount++;
        move(x, y, (direction + 1) % 4, movingFailCount + 1);
    }
}