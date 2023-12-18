import java.util.*;
import java.io.*;

public class Main {
    private static int r, c;
    private static char[][] maze;
    private static int[][] fireTime;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        maze = new char[r][c];
        fireTime = new int[r][c];

        Queue<Node> fireQueue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            Arrays.fill(fireTime[i], -1);
        }


        Node jihun = new Node(0, 0, 0);

        for (int i = 0; i < r; i++) {
            String row = reader.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = row.charAt(j);

                if (maze[i][j] == 'J') {
                    jihun.x = i;
                    jihun.y = j;
                } else if (maze[i][j] == 'F') {
                    fireTime[i][j] = 0;
                    fireQueue.offer(new Node(i, j, 0));
                }
            }
        }

        fire(fireQueue);
        int answer = find(jihun);
        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
    }

    private static int find(Node jihun) {
        boolean[][] visit = new boolean[r][c];
        Queue<Node> jihunQueue = new LinkedList<>();
        jihunQueue.offer(jihun);

        while(!jihunQueue.isEmpty()) {
            jihun = jihunQueue.poll();
            visit[jihun.x][jihun.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = jihun.x + dx[i];
                int ny = jihun.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    return jihun.time + 1;
                }

                if (!visit[nx][ny] && maze[nx][ny] == '.' && (fireTime[nx][ny] == -1 || fireTime[nx][ny] > jihun.time + 1)) {
                    jihunQueue.offer(new Node(nx, ny, jihun.time + 1));
                    visit[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    private static void fire(Queue<Node> fireQueue) {
        while(!fireQueue.isEmpty()) {
            Node fire = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;

                if (maze[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = fire.time + 1;
                    fireQueue.offer(new Node(nx, ny, fireTime[nx][ny]));
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}