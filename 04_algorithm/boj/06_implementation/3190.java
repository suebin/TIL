import java.util.*;
import java.io.*;

public class Main {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        int[][] board = new int[n][n];

        board[0][0] = -1; // 뱀

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 1; // 사과
        }

        int l = Integer.parseInt(reader.readLine());
        Queue<Dir> dirQueue = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            dirQueue.offer(new Dir(x, c));
        }

        int ans = getGameFinishTime(board, dirQueue, n);
        System.out.print(ans);
    }

    private static int getGameFinishTime(int[][] board, Queue<Dir> dirQueue, int n) {
        int dir = 0;
        int time = 0;
        Deque<Snake> snake = new ArrayDeque<>();
        snake.offerFirst(new Snake(0, 0));

        while (true) {
            if (!dirQueue.isEmpty()) dir = checkDirection(time, dirQueue, dir);
            time++;

            Snake snakeHead = snake.peekFirst();
            int nx = snakeHead.x + dx[dir];
            int ny = snakeHead.y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            if (board[nx][ny] == -1) break;

            if (board[nx][ny] != 1) {
                Snake snakeTail = snake.pollLast();
                board[snakeTail.x][snakeTail.y] = 0;
            }
            board[nx][ny] = -1;
            snake.offerFirst(new Snake(nx, ny));
        }

        return time;
    }

    private static int checkDirection(int time, Queue<Dir> dirQueue, int dir) {
        if (time == dirQueue.peek().x) {
            String c = dirQueue.poll().c;

            if (c.equals("L")) {
                dir--;
                if (dir == -1) dir = 3;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        return dir;
    }

    private static class Snake {
        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Dir {
        int x;
        String c;

        public Dir(int x, String c) {
            this.x = x;
            this.c = c;
        }
    }
}