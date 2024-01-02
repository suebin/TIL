import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] map;
    private static List<Virus> virusList;
    private static int safetyAreaCnt;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        safetyAreaCnt = 0;

        map = new int[n][m];
        virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virusList.add(new Virus(i, j));
                if (map[i][j] == 0) safetyAreaCnt++;
            }
        }

        find(0);
        System.out.print(ans);
    }

    private static void find(int wall) {
        if (wall == 3) {
            ans = Math.max(ans, getSafetyAreaCnt() - wall);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    find(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int getSafetyAreaCnt() {
        int virusCnt = 0;
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        for (Virus virus : virusList) {
            queue.offer(virus);
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();
            visit[virus.x][virus.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!visit[nx][ny] && map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    virusCnt++;
                    queue.offer(new Virus(nx, ny));
                }
            }
        }

        return safetyAreaCnt - virusCnt;
    }

    private static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}