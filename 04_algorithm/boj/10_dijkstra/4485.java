import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static int[][] size;
    private static boolean[][] visit;

    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        int cnt = 1;
        String temp;

        while (!(temp = reader.readLine()).equals("0")) {
            n = Integer.parseInt(temp);
            map = new int[n][n];
            size = new int[n][n];
            visit = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    size[i][j] = MAX_VALUE;
                }
            }

            bfs(new Node(0, 0, map[0][0]));
            result.append("Problem ")
                    .append(cnt)
                    .append(": ")
                    .append(size[n - 1][n - 1])
                    .append("\n");
            cnt++;
        }

        System.out.print(result);
        reader.close();
    }

    private static void bfs(Node node) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            node = queue.poll();
            visit[node.x][node.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                if (!visit[nx][ny] && size[nx][ny] > map[nx][ny] + node.size) {
                    size[nx][ny] = map[nx][ny] + node.size;
                    queue.add(new Node(nx, ny, size[nx][ny]));
                    visit[nx][ny] = true;
                }
            }
        }

    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int size;

        public Node(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(Node o) {
            return this.size - o.size;
        }
    }
}