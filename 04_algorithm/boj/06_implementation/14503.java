import java.util.*;
import java.io.*;

public class Main {
    private static int[][] room;
    private static int cleaningCnt = 0;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[] left = {3, 0, 1, 2};
    private static int[] back = {2, 3, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        room = new int[n][m];

        st = new StringTokenizer(reader.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        executeCleaning(new Robovac(r, c, d));
        System.out.println(cleaningCnt);
    }

    private static void executeCleaning(Robovac robovac) {
        if (room[robovac.r][robovac.c] == 0) {
            room[robovac.r][robovac.c] = -1; // 청소를 한 빈칸
            cleaningCnt++;
        }

        for (int i = 0; i < 4; i++) {
            robovac.d = left[robovac.d];
            int nextX = robovac.r + dx[robovac.d];
            int nextY = robovac.c + dy[robovac.d];

            if (room[nextX][nextY] == 0) {
                executeCleaning(new Robovac(nextX, nextY, robovac.d));
                return;
            }
        }

        int nextX = robovac.r + dx[back[robovac.d]];
        int nextY = robovac.c + dy[back[robovac.d]];

        if (room[nextX][nextY] != 1)
            executeCleaning(new Robovac(nextX, nextY, robovac.d));
    }

    private static class Robovac {
        private int r;
        private int c;
        private int d;

        public Robovac(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}