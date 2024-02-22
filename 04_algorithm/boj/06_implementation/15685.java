import java.io.*;
import java.util.*;

public class Main {
    private static boolean[][] map;
    private static final int len = 100;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new boolean[len + 1][len + 1];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            draw(x, y, getDirList(d, g));
        }

        System.out.print(getCnt());
    }

    private static List<Integer> getDirList(int d, int g) {
        List<Integer> dirList = new ArrayList<>();
        dirList.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = dirList.size() - 1; j >= 0; j--) {
                int dir = (dirList.get(j) + 1) % 4;
                dirList.add(dir);
            }
        }
        return dirList;
    }

    private static void draw(int x, int y, List<Integer> dirList) {
        map[x][y] = true;

        for (int dir : dirList) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            map[nx][ny] = true;

            x = nx;
            y = ny;
        }
    }

    private static int getCnt() {
        int cnt = 0;
        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1]) cnt++;
            }
        }
        return cnt;
    }
}