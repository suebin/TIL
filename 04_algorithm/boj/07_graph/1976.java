import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 1; j <= n; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) union(i, j);
            }
        }

        int[] plan = new int[m];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        String ans = "YES";
        for (int i = 0; i < m - 1; i++) {
            if (find(plan[i]) != find(plan[i + 1])) {
                ans = "NO";
                break;
            }
        }

        System.out.print(ans);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) parents[y] = x;
        else parents[x] = y;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}