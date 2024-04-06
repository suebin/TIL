import java.io.*;
import java.util.*;

public class Main {
    private static long[] times;
    private static final long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] isVisible = new boolean[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            isVisible[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
        }
        isVisible[n - 1] = false;

        times = new long[n];
        Arrays.fill(times, MAX);

        List<Edge>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (isVisible[a] || isVisible[b]) continue;

            edges[a].add(new Edge(b, t));
            edges[b].add(new Edge(a, t));
        }


        System.out.print(dijkstra(edges, n));
    }

    private static long dijkstra(List<Edge>[] edges, int n) {
        boolean[] visit =  new boolean[n];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(0, 0));
        times[0] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (visit[edge.to]) continue;
            visit[edge.to] = true;

            for (Edge nextEdge : edges[edge.to]) {
                if (times[nextEdge.to] >= times[edge.to] + nextEdge.time) {
                    times[nextEdge.to] = times[edge.to] + nextEdge.time;
                    queue.offer(new Edge(nextEdge.to, times[nextEdge.to]));
                }
            }
        }

        return times[n - 1] == MAX ? -1 : times[n - 1];
    }

    private static class Edge implements Comparable<Edge> {
        int to;
        long time;

        public Edge(int to, long time) {
            this.to =  to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.time - o.time);
        }
    }
}