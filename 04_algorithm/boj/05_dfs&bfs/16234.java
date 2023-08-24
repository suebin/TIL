import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int l;
    private static int r;
    private static int[][] population;
    private static boolean[][] visit;
    private static Queue<Nation> nationQueueForHumanMigration;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        population = new int[n][n];
        visit = new boolean[n][n];
        nationQueueForHumanMigration = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getDurationOfHumanMigration(0));
        reader.close();
    }

    private static int getDurationOfHumanMigration(int duration) {
        boolean hasHumanMigration = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    int populationCnt = checkForHumanMigration(i, j);

                    if (nationQueueForHumanMigration.size() > 1) {
                        performHumanMigration(populationCnt);
                        hasHumanMigration = true;
                    }

                    nationQueueForHumanMigration.clear();
                }
            }
        }

        if (hasHumanMigration) {
            for (boolean[] arr : visit) {
                Arrays.fill(arr, false);
            }

            duration = getDurationOfHumanMigration(duration + 1);
        }

        return duration;
    }

    private static int checkForHumanMigration(int x, int y) {
        Queue<Nation> nationQueue = new LinkedList<>();
        nationQueue.offer(new Nation(x, y));
        visit[x][y] = true;
        nationQueueForHumanMigration.offer(new Nation(x, y));
        int populationCnt = population[x][y];

        while (!nationQueue.isEmpty()) {
            Nation nation = nationQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = nation.x + dx[i];
                int ny = nation.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (!visit[nx][ny]) {
                    int gap = Math.abs(population[nation.x][nation.y] - population[nx][ny]);

                    if (gap >= l && gap <= r) {
                        nationQueue.offer(new Nation(nx, ny));
                        visit[nx][ny] = true;
                        nationQueueForHumanMigration.offer(new Nation(nx, ny));
                        populationCnt += population[nx][ny];
                    }
                }
            }
        }

        return populationCnt;
    }

    private static void performHumanMigration(int populationCnt) {
        int newPopulation = populationCnt / nationQueueForHumanMigration.size();

        for (Nation nation : nationQueueForHumanMigration) {
            population[nation.x][nation.y] = newPopulation;
        }
    }

    private static class Nation {
        int x;
        int y;

        public Nation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}