import java.util.*;
import java.io.*;

public class Main {
    private static int[][] dusts;
    private static int[][] spreadedDusts;
    private static int cleaner;
    private static int r;
    private static int c;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        dusts = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < c; j++) {
                dusts[i][j] = Integer.parseInt(st.nextToken());

                if (dusts[i][j] == -1) {
                    cleaner = i;
                }
            }
        }

        while (t-- > 0) {
            spreadedDusts = new int[r][c];
            spreadedDusts[cleaner - 1][0] = spreadedDusts[cleaner][0] = -1;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (dusts[i][j] > 0) {
                        spread(i, j);
                    }
                }
            }

            executeCleaner();
            dusts = spreadedDusts;
        }

        System.out.println(getSum());
        reader.close();

    }

    public static void spread(int x, int y) {
        int spreadedDust = dusts[x][y] / 5;
        int cnt = 0;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c || dusts[nx][ny] == -1) continue;

            spreadedDusts[nx][ny] += spreadedDust;
            cnt++;
        }

        spreadedDusts[x][y] += dusts[x][y] - spreadedDust * cnt;
    }

    public static void executeCleaner() {
        int top = cleaner - 1;

        for (int i = top - 1; i > 0; i--) {
            spreadedDusts[i][0] = spreadedDusts[i - 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            spreadedDusts[0][i] = spreadedDusts[0][i + 1];
        }

        for (int i = 0; i < top; i++) {
            spreadedDusts[i][c - 1] = spreadedDusts[i + 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            spreadedDusts[top][i] = spreadedDusts[top][i - 1];
        }

        spreadedDusts[top][1] = 0;

        int bottom = cleaner;

        for (int i = bottom + 1; i < r - 1; i++) {
            spreadedDusts[i][0] = spreadedDusts[i + 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            spreadedDusts[r - 1][i] = spreadedDusts[r - 1][i + 1];
        }

        for (int i = r - 1; i > bottom; i--) {
            spreadedDusts[i][c - 1] = spreadedDusts[i - 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            spreadedDusts[bottom][i] = spreadedDusts[bottom][i - 1];
        }

        spreadedDusts[bottom][1] = 0;
    }

    public static int getSum() {
        int sum = 2;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += dusts[i][j];
            }
        }

        return sum;
    }
}