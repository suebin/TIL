import java.util.*;
import java.io.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int calculation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (calculation == 0) merge(a, b);
            if (calculation == 1) isUnion(a, b);
        }
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;
        parent[y] = x;
    }

    private static void isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}