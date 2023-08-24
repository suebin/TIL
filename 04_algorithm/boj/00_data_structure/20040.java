import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (isCycle(x, y)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
        reader.close();
    }

    private static boolean isCycle(int x, int y) {
        if (!isUnion(x, y)) {
            merge(x, y);
            return false;
        }

        return true;
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        parents[y] = x;
    }

    private static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}