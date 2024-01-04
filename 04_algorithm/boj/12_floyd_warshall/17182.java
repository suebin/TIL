import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] time;
    private static boolean[] visit;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        ans = Integer.MAX_VALUE;
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        time = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall();
        dfs(0, k, 0);

        System.out.print(ans);
    }

    private static void dfs(int depth, int start, int totalTime) {
        if (depth == n) {
            ans = Math.min(ans, totalTime);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i, totalTime + time[start][i]);
                visit[i] = false;
            }
        }
    }

    private static void floydWarshall() {
        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    time[i][j] = Math.min(time[i][j], time[i][m] + time[m][j]);
                }
            }
        }
    }
}