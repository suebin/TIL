import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int ans;
    private static String[] balls;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());

        balls = reader.readLine().split("");

        ans = Integer.MAX_VALUE;

        moveBallToLeft("B", "R");
        moveBallToLeft("R", "B");
        moveBallToRight("B", "R");
        moveBallToRight("R", "B");

        System.out.print(ans);
    }

    private static void moveBallToLeft(String color, String otherColor) {
        int cnt = 0;
        boolean hasDifferentColor = false;
        for (int i = 0; i < n; i++) {
            if (hasDifferentColor && balls[i].equals(color)) cnt++;
            if (balls[i].equals(otherColor)) hasDifferentColor = true;
        }
        ans = getMinValue(ans, cnt);
    }

    private static void moveBallToRight(String color, String otherColor) {
        int cnt = 0;
        boolean hasDifferentColor = false;
        for (int i = n - 1; i >= 0; i--) {
            if (hasDifferentColor && balls[i].equals(color)) cnt++;
            if (balls[i].equals(otherColor)) hasDifferentColor = true;
        }
        ans = getMinValue(ans, cnt);
    }

    private static int getMinValue(int x, int y) {
        return Math.min(x, y);
    }
}