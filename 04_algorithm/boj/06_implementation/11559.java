import java.util.*;
import java.io.*;

public class Main {
    private static String[][] field;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};
    private static final int ROW_SIZE = 12;
    private static final int COL_SIZE = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        field = new String[ROW_SIZE][COL_SIZE];

        for (int i = 0; i < ROW_SIZE; i++) {
            field[i] = reader.readLine().split("");
        }

        System.out.println(check());
        reader.readLine();
    }

    private static int check() {
        int cnt = 0;

        while (true) {
            boolean[][] visit = new boolean[ROW_SIZE][COL_SIZE];
            List<List<Puyo>> bumbList = new ArrayList<>();

            for (int i = 0; i < ROW_SIZE; i++) {
                for (int j = 0; j < COL_SIZE; j++) {
                    if (!visit[i][j] && !field[i][j].equals(".")) {
                        List<Puyo> list = bfs(i, j, visit);
                        if (list.size() > 3) {
                            bumbList.add(list);
                        }
                    }
                }
            }

            if (bumbList.size() == 0) break;

            explodePuyo(bumbList);
            replacePuyo();
            cnt++;
        }

        return cnt;
    }

    private static List<Puyo> bfs(int x, int y, boolean[][] visit) {
        String color = field[x][y];
        Queue<Puyo> queue = new LinkedList<>();
        List<Puyo> list = new ArrayList<>();
        queue.add(new Puyo(x, y));

        while (!queue.isEmpty()) {
            Puyo puyo = queue.poll();
            list.add(puyo);
            visit[puyo.x][puyo.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = puyo.x + dx[i];
                int ny = puyo.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= ROW_SIZE || ny >= COL_SIZE) continue;

                if (!visit[nx][ny] && color.equals(field[nx][ny])) {
                    queue.add(new Puyo(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

        return list;
    }

    private static void explodePuyo(List<List<Puyo>> bumbList) {
        for (List<Puyo> list : bumbList) {
            for (Puyo puyo : list) {
                field[puyo.x][puyo.y] = ".";
            }
        }
    }

    private static void replacePuyo() {
        for (int i = 0; i < COL_SIZE; i++) {
            for (int j = ROW_SIZE - 1; j >= 0; j--) {
                if (field[j][i].equals(".")) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (!field[k][i].equals(".")) {
                            field[j][i] = field[k][i];
                            field[k][i] = ".";
                            break;
                        }
                    }
                }
            }
        }
    }

    private static class Puyo {
        int x;
        int y;

        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}