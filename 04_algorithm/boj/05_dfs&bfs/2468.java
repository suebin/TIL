import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[][] visit;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        int maxHeight = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxSecureAreaCnt = 0;

        for (int i = 0; i < maxHeight; i++) {
            int secureAreaCnt = 0;
            visit = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visit[j][k] && map[j][k] > i) {
                        bfs(i, j, k);
                        secureAreaCnt++;
                    }
                }
            }

            maxSecureAreaCnt = Math.max(secureAreaCnt, maxSecureAreaCnt);
        }

        System.out.println(maxSecureAreaCnt);
    }

    private static void bfs(int height, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            x = now[0];
            y = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                    continue;
                }

                if (!visit[nextX][nextY] && map[nextX][nextY] > height) {
                    queue.offer(new int[]{nextX, nextY});
                    visit[nextX][nextY] = true;
                }
            }
        }
    }
}