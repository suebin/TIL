import java.io.*;
import java.util.*;

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

        for (int i = 0; i < n; i++) {
            String[] arr = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (arr[j].equals("1")) map[i][j] = 1;
            }
        }

        System.out.print(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[n][m][2];
        queue.offer(new Node(0, 0, 1, false));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) return node.dist;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == 0) {
                    if (!node.hasBroken && !visit[nx][ny][0]) {
                        visit[nx][ny][0] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, false));
                    } else if (node.hasBroken && !visit[nx][ny][1]) {
                        visit[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, true));
                    }
                } else {
                    if (!node.hasBroken && !visit[nx][ny][1]) {
                        visit[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, true));
                    }
                }
            }
        }

        return -1;
    }

    private static class Node {
        int x;
        int y;
        int dist;
        boolean hasBroken;

        public Node(int x, int y, int dist, boolean hasBroken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.hasBroken = hasBroken;
        }
    }
}