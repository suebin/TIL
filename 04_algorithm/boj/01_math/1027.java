import java.util.*;
import java.io.*;

public class Main {
    private static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        height = new int[n + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            double slope = Integer.MAX_VALUE;
            for (int j = i - 1; j > 0; j--) {
                double now = calculateSlope(i, j);
                if (slope > now) {
                    slope = now;
                    cnt++;
                }
            }

            slope = Integer.MIN_VALUE;
            for (int j = i + 1; j <= n; j++) {
                double now = calculateSlope(i, j);
                if (slope < now) {
                    slope = now;
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }

    private static double calculateSlope(int x, int y) {
        return (double) (height[x] - height[y]) / (x - y);
    }
}