import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static int cheeseCnt;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheeseCnt = 0;

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheeseCnt++;
            }
        }

        int hour = 0;

        while (cheeseCnt > 0) {
            // 1. 외부공기(= -1)인지 체크하기
            checkAir();

            // 2. 치즈 녹이기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) meltCheese(i, j);
                }
            }

            hour++;
        }

        System.out.print(hour);
    }

    private static void meltCheese(int x, int y) {
        int airCnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[nx][ny] == -1) airCnt++;

        }

        if (airCnt >= 2) {
            map[x][y] = 0;
            cheeseCnt--;
        }
    }

    private static void checkAir() {
        int x = 0;
        int y = 0;

        boolean[][] visit = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            x = now[0];
            y = now[1];
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!visit[nx][ny] && map[nx][ny] != 1) {
                    queue.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    map[nx][ny] = -1;
                }
            }
        }
    }
}