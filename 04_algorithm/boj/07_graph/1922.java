import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;
    private static int minTotalCost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        List<Edge> edgeList = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a, b, c));
        }

        kruskal(edgeList, n);

        System.out.println(minTotalCost);
        reader.close();
    }

    private static void kruskal(List<Edge> edgeList, int n) {
        Collections.sort(edgeList);

        int edgeCnt = 0;

        for (Edge edge : edgeList) {
            if (edgeCnt == n - 1) break;

            if (!isUnion(edge.a, edge.b)) {
                union(edge.a, edge.b);
                edgeCnt++;
                minTotalCost += edge.cost;
            }
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) parents[x] = y;
        else if (y > x) parents[y] = x;
    }

    private static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}