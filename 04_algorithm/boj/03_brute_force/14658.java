import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    private static int l, k;
    private static List<Star> stars;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars.add(new Star(x, y));
        }

        int ans = Integer.MAX_VALUE;
        for (Star star1 : stars) {
            for (Star star2 : stars) {
                ans = Math.min(ans, getStarCnt(star1.x, star2.y));
            }
        }

        System.out.print(ans);
    }

    private static int getStarCnt(int x, int y) {
        int cnt = 0;
        for (Star star : stars) {
            if (star.x >= x && star.x <= x + l && star.y >= y && star.y <= y + l)
                cnt++;
        }

        return k - cnt;
    }

    private static class Star {
        int x;
        int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}