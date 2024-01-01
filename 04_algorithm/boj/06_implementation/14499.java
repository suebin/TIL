import java.util.*;
import java.io.*;

public class Main {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(0, 0, 0, 0, 0, 0);
        StringBuilder ans = new StringBuilder();

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            int order = Integer.parseInt(st.nextToken());

            int nx = x + dx[order - 1];
            int ny = y + dy[order - 1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            x = nx;
            y = ny;

            dice = roll(dice, order);
            copy(dice, x, y);

            ans.append(dice.top).append("\n");
        }

        System.out.print(ans);
    }

    private static void copy(Dice dice, int x, int y) {
        if (map[x][y] == 0) {
            map[x][y] = dice.bottom;
        } else {
            dice.bottom = map[x][y];
            map[x][y] = 0;
        }
    }

    private static Dice roll(Dice dice, int order) {
        int t = dice.top;
        int b = dice.bottom;
        int u = dice.up;
        int d = dice.down;
        int l = dice.left;
        int r = dice.right;

        switch (order) {
            case 1:
                dice = new Dice(l, u, d, b, t, r);
                break;
            case 2:
                dice = new Dice(r, u, d, t, b, l);
                break;
            case 3:
                dice = new Dice(u, b, t, l, r, d);
                break;
            case 4:
                dice = new Dice(d, t, b, l, r, u);
        }

        return dice;
    }

    private static class Dice {
        int top, up, down, left, right, bottom;

        Dice(int top, int up, int down, int left, int right, int bottom) {
            this.top = top;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }
    }
}