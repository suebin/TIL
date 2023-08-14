import java.util.*;
import java.io.*;

public class Main {
    private static boolean[][] connection;
    private static boolean[] visit;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        connection = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            connection[u][v] = true;
            connection[v][u] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
        reader.close();
    }

    private static void dfs(int num) {
        visit[num] = true;
        for (int i = 1; i <= n; i++) {
            if (connection[num][i] && !visit[i]) {
                dfs(i);
            }
        }
    }
}