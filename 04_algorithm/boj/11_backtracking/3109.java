import java.io.*;
import java.util.*;

public class Main {
    private static int r, c;
    private static char[][] map;
    private static boolean isPossible;
    private static int pipeCnt;
    private static final int[] dx = {-1, 0, 1};
    private static final int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            isPossible = false;
            map[i][0] = 'x';
            backTracking(i, 0);
        }

        System.out.print(pipeCnt);
    }

    private static void backTracking(int x, int y) {
        if (y == c - 1) {
            isPossible = true;
            pipeCnt++;
            return;
        }

        for (int j = 0; j < 3; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];

            if (nx < 0 || nx >= r || ny >= c || map[nx][ny] == 'x') continue;
            if (isPossible) continue;

            map[nx][ny] = 'x';
            backTracking(nx, ny);
        }
    }
}