import java.io.*;
import java.util.*;

public class Main {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        long answer = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            queue.offer(new Edge(a, b, c));
        }

        for (int i = 0; i < e; i++) {
            Edge edge = queue.poll();
            if (union(edge.from, edge.to)) answer += edge.weight;
        }

        System.out.print(answer);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (x < y) parents[y] = x;
        else parents[x] = y;
        return true;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }

    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        long weight;

        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.weight - o.weight);
        }
    }
}