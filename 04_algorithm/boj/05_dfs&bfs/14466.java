import java.util.*;
import java.io.*;

public class Main {
    private static List<Node>[][] bridges;
    private static Node[] cows;
    private static int n;
    private static int k;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        bridges = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bridges[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            bridges[a][b].add(new Node(c, d));
            bridges[c][d].add(new Node(a, b));
        }

        cows = new Node[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            cows[i] = new Node(x, y);
        }


        for (int i = 0; i < k; i++) {
            bfs(cows[i], i);
        }

        System.out.print(result);
        reader.close();
    }

    private static void bfs(Node node, int cowNum) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];

        queue.add(node);
        visit[node.x][node.y] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();

            for (int j = 0; j < 4; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                boolean isBridge = false;
                for (Node n : bridges[node.x][node.y]) {
                    if (n.x == nx && n.y == ny) {
                        isBridge = true;
                        break;
                    }
                }

                if (!visit[nx][ny] && !isBridge) {
                    queue.offer(new Node(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

        for (int j = cowNum + 1; j < k; j++) {
            Node c = cows[j];
            if (!visit[c.x][c.y]) result++;
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}