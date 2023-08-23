import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    map[i][j] = -1;
                } else if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);
        printMap();
        reader.close();
    }

    private static void bfs(int x, int y) {
        boolean[][] visit = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visit[x][y] = true;
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            x = location[0];
            y = location[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (!visit[nx][ny] && map[nx][ny] != 0) {
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }
    }

    private static void printMap() {
        StringBuilder result = new StringBuilder();

        for (int[] distances : map) {
            for (int distance : distances) {
                result.append(distance).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}