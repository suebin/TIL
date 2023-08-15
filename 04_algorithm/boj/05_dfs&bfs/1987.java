import java.util.*;
import java.io.*;

public class Main {
    private static int r;
    private static int c;
    private static char[][] board;
    private static int maxCnt = 1;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};
    private static final boolean[] visit = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = reader.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(maxCnt);
        reader.close();
    }

    private static void dfs(int x, int y, int depth) {
        visit[board[x][y] - 65] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                continue;

            if (!visit[board[nx][ny] - 65]) {
                visit[board[nx][ny] - 65] = true;
                dfs(nx, ny, depth + 1);
                maxCnt = Math.max(depth + 1, maxCnt);
                visit[board[nx][ny] - 65] = false;
            }
        }
    }
}