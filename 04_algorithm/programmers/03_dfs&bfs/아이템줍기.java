import java.util.*;

class Solution {
    private static int[][] map;
    private static int answer = 0;
    private static final int len = 101;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[len][len];

        for (int[] r : rectangle) {
            draw(twice(r[0]), twice(r[1]), twice(r[2]), twice(r[3]));
        }

        bfs(twice(characterX), twice(characterY), twice(itemX), twice(itemY));
        return answer / 2;
    }

    private static void bfs(int x, int y, int itemX, int itemY) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[len][len];
        queue.offer(new int[]{x, y, 0});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == itemX && cur[1] == itemY) {
                answer = cur[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= len || ny >= len) continue;

                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny, cur[2] + 1});
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static void draw(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) continue;

                if (i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1;
                else map[i][j] = 2;
            }
        }
    }

    private static int twice(int x) {
        return 2 * x;
    }
}