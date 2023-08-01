public class Main {
    private static final int[] dx = {-1, 0, 0, 1, 0, 0};
    private static final int[] dy = {0, -1, 1, 0, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};
    private static int m, n, h;
    private static Queue<Tomato> tomatoQueue;
    private static int ripeTomatoCnt = 0;
    private static int unripeTomatoCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][][] tomatoes = new int[h][n][m];
        tomatoQueue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(reader.readLine());
                for (int k = 0; k < m; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        tomatoQueue.add(new Tomato(i, j, k, 0));
                        ripeTomatoCnt++;
                    } else if (tomatoes[i][j][k] == 0) {
                        unripeTomatoCnt++;
                    }
                }
            }
        }

        if (ripeTomatoCnt == 0) {
            System.out.println(-1);
            return;
        }

        if (unripeTomatoCnt == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(tomatoes));
    }

    private static int bfs(int[][][] tomatoes) {
        int minDays = 0;

        while (!tomatoQueue.isEmpty()) {
            Tomato tomato = tomatoQueue.poll();
            int nextDays = tomato.days + 1;

            for (int i = 0; i < 6; i++) {
                int nextZ = tomato.z + dz[i];
                int nextX = tomato.x + dx[i];
                int nextY = tomato.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= n || nextY >= m || nextZ >= h) {
                    continue;
                }

                if (tomatoes[nextZ][nextX][nextY] == 0) {
                    tomatoQueue.add(new Tomato(nextZ, nextX, nextY, nextDays));
                    tomatoes[nextZ][nextX][nextY] = 1;
                    minDays = Math.max(minDays, nextDays);
                    unripeTomatoCnt--;
                }
            }
        }

        return (unripeTomatoCnt == 0) ? minDays : -1;
    }

    private static class Tomato {
        private final int z;
        private final int x;
        private final int y;
        private final int days;

        public Tomato(int z, int x, int y, int days) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }
}