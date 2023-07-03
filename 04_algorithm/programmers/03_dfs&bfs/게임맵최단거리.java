import java.util.*;

class Solution {
    static int[][] visit;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public int solution(int[][] maps) {
        visit = new int[maps.length][maps[0].length];
        int answer = bfs(maps, visit);
        return answer;
    }

    static int bfs(int[][] maps, int[][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = location[0] + dx[i];
                int y = location[1] + dy[i];

                if (x < 0 || y < 0 || x > maps.length - 1 || y > maps[0].length - 1) {
                    continue;
                }

                if (visit[x][y] == 0 && maps[x][y] == 1) {
                    visit[x][y] = visit[x - dx[i]][y - dy[i]] + 1;
                    if (x == maps.length - 1 && y == maps[0].length - 1) {
                        return visit[x][y];
                    }
                    queue.add(new int[]{x, y});
                }
            }
        }

        return -1;
    }
}