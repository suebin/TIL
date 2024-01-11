import java.util.*;
import java.io.*;

class Solution {
    private static int n, m;
    private static boolean[][] visit;
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};
    private static int[] oilCnts;

    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;

        visit = new boolean[n][m];
        oilCnts = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && land[i][j] == 1) bfs(i, j, land);
            }
        }

        for (int oilCnt : oilCnts) {
            answer = Math.max(answer, oilCnt);
        }

        return answer;
    }

    private static void bfs(int x, int y, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> oilIdxSet = new HashSet<>();
        int oilCnt = 0;
        queue.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            x = now[0];
            y = now[1];

            oilCnt++;
            oilIdxSet.add(y);

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!visit[nx][ny] && land[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int idx : oilIdxSet) {
            oilCnts[idx] += oilCnt;
        }
    }
}