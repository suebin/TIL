import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visit;
    static int n;
    static int m;
    static String[][] battleground;
    static int ourTeamPower = 0;
    static int enemyTeamPower = 0;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        battleground = new String[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] colors = reader.readLine().split("");
            for (int j = 0; j < n; j++) {
                String color = colors[j];
                battleground[i][j] = color;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    calculateTeamPower(i, j);
                }
            }
        }

        System.out.println(ourTeamPower + " " + enemyTeamPower);
        reader.close();
    }

    static void calculateTeamPower(int x, int y) {
        String teamColor = battleground[x][y];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int count = 0;

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            x = location[0];
            y = location[1];

            visit[x][y] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == -1 || ny == -1 || nx >= m || ny >= n) {
                    continue;
                }

                if (battleground[nx][ny].equals(teamColor) && !visit[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }

        if (teamColor.equals("W")) {
            ourTeamPower += (count * count);
        } else {
            enemyTeamPower += (count * count);
        }
    }
}