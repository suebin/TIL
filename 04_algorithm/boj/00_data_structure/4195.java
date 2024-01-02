import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;
    private static int[] levels;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(reader.readLine());

            Map<String, Integer> friends = new HashMap<>();
            parents = new int[f * 2];
            levels = new int[f * 2];

            for (int j = 0; j < f * 2; j++) {
                parents[j] = j;
                levels[j] = 1;
            }

            int idx = 0;
            for (int j = 0; j < f; j++) {
                st = new StringTokenizer(reader.readLine());

                String x = st.nextToken();
                String y = st.nextToken();

                if (!friends.containsKey(x)) {
                    friends.put(x, idx++);
                }

                if (!friends.containsKey(y)) {
                    friends.put(y, idx++);
                }

                ans.append(union(friends.get(x), friends.get(y))).append("\n");
            }
        }

        System.out.print(ans);
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = parents[x];
            levels[x] += levels[y];
        }

        return levels[x];
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}