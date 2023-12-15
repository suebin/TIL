import java.util.*;
import java.io.*;

public class Main {
    private static int n, k, p, x;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken()); // 1 ~ n 층까지 이용 가능
        k = Integer.parseInt(st.nextToken()); // 디스플레이 자리의 수
        p = Integer.parseInt(st.nextToken()); // 1 ~ p 개 반전 가능
        x = Integer.parseInt(st.nextToken()); // 실제 층

        System.out.print(find());
    }

    private static int find() {
        int[] display = getDisplay(x);
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            if (isAvailable(i, display)) cnt++;
        }
        return cnt;
    }

    private static boolean isAvailable(int num, int[] display) {
        boolean[][] led = getLed();
        int[] numDisplay = getDisplay(num);
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 7; j++) {
                if (led[numDisplay[i]][j] != led[display[i]][j]) cnt++;
                if (p < cnt) return false;
            }
        }
        return true;
    }

    private static int[] getDisplay(int num) {
        int[] display = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            display[i] = num % 10;
            num /= 10;
        }
        return display;
    }

    private static boolean[][] getLed() {
        int[][] off = {{0, 3}, {1, 0}, {1, 1}, {1, 3}, {1, 4}, {1, 6},
                {2, 1}, {2, 5}, {3, 1}, {3, 4}, {4, 0},
                {4, 4}, {4, 6}, {5, 2}, {5, 4}, {6, 2},
                {7, 1}, {7, 3}, {7, 4}, {7, 6}, {9, 4}};

        boolean[][] led = new boolean[10][7];

        for (boolean[] l : led) {
            Arrays.fill(l, true);
        }

        for (int[] o : off) {
            led[o[0]][o[1]] = false;
        }
        return led;
    }
}