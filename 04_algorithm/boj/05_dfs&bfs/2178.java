import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visit;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            String[] nums = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int result = getMinCount();
        System.out.println(result);
        reader.close();
    }

    static int getMinCount() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            int x = location[0];
            int y = location[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == -1 || ny == -1 || nx >= n || ny >= m) {
                    continue;
                }

                if (maze[nx][ny] == 1 && !visit[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    maze[nx][ny] = maze[x][y] + 1;
                    visit[nx][ny] = true;
                }
            }
        }

        return maze[n - 1][m - 1];
    }
}