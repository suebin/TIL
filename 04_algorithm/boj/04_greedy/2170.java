import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Dot[] dots = new Dot[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            dots[i] = new Dot(x, y);
        }

        Arrays.sort(dots);

        long len = dots[0].y - dots[0].x;
        long prevY = dots[0].y;

        for (int i = 1; i < n; i++) {
            long nowX = dots[i].x;
            long nowY = dots[i].y;

            if (nowY > prevY) {
                len += (nowY - nowX);
                if (prevY > nowX) len -= (prevY - nowX);
            }

            prevY = Math.max(prevY, nowY);
        }

        System.out.print(len);
    }

    private static class Dot implements Comparable<Dot> {
        long x;
        long y;

        public Dot(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot o) {
            if (this.x == o.x) return (int) (o.y - this.y);
            return (int) (this.x - o.x);
        }
    }
}