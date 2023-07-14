import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[][] visit;
    private static List<Integer> houses;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];
        houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] nums = reader.readLine().split("");

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int totalHousingComplexCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    totalHousingComplexCnt++;
                    bfs(i, j);
                }

            }
        }

        Collections.sort(houses);

        StringBuilder answer = new StringBuilder();
        answer.append(totalHousingComplexCnt + "\n");

        for (int houseCnt : houses) {
            answer.append(houseCnt + "\n");
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;

        int houseCnt = 0;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            houseCnt++;

            x = now[0];
            y = now[1];

            for (int k = 0; k < 4; k++) {
                int nextX = x + dx[k];
                int nextY = y + dy[k];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                    continue;
                }

                if (map[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    visit[nextX][nextY] = true;
                }
            }
        }

        houses.add(houseCnt);
    }
}