import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] path;
    static boolean[][] visit;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int n;
    static int m;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        path = new boolean[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());
            path[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visit[i][j] && path[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
        reader.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int count = 0;
        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            x = location[0];
            y = location[1];
            visit[x][y] = true;
            count++;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 1 || ny < 1 || nx > n || ny > m) {
                    continue;
                }

                if (!visit[nx][ny] && path[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }

        max = Math.max(max, count);
    }
}