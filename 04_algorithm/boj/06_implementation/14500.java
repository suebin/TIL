import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] paper;
    private static boolean[][] visit;
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;

        paper = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                bfs(1, paper[i][j], i, j);
                visit[i][j] = false;
            }
        }

        System.out.print(ans);
    }

    private static void bfs(int cnt, int sum, int x, int y) {
        if (cnt == 4) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (!visit[nx][ny]) {
                if (cnt == 2) {
                    visit[nx][ny] = true;
                    bfs(cnt + 1, sum + paper[nx][ny], x, y);
                    visit[nx][ny] = false;
                }

                visit[nx][ny] = true;
                bfs(cnt + 1, sum + paper[nx][ny], nx, ny);
                visit[nx][ny] = false;
            }
        }
    }
}