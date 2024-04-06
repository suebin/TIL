import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] nums = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(nums[j]);
            }
        }

        System.out.print(bfs(maze, n, m));
    }

    private static int bfs(int[][] maze, int n, int m) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        boolean[][] visit = new boolean[n][m];
        PriorityQueue<Algospot> queue = new PriorityQueue<>();

        queue.offer(new Algospot(0, 0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Algospot algospot = queue.poll();

            if (algospot.x == n - 1 && algospot.y == m - 1) {
                return algospot.breakCnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = algospot.x + dx[i];
                int ny = algospot.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!visit[nx][ny]) {
                    queue.offer(new Algospot(nx, ny, algospot.breakCnt + maze[nx][ny]));
                    visit[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    private static class Algospot implements Comparable<Algospot> {
        int x;
        int y;
        int breakCnt;

        public Algospot(int x, int y, int breakCnt) {
            this.x =  x;
            this.y = y;
            this.breakCnt = breakCnt;
        }

        @Override
        public int compareTo(Algospot o) {
            return this.breakCnt - o.breakCnt;
        }
    }
}