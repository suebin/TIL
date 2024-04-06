import java.io.*;
import java.util.*;

public class Main {
    private static List<Edge>[] edges;
    private static int[] times;
    private static int[] log;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        times = new int[n + 1];
        log = new int[n + 1];
        Arrays.fill(times, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        dijkstra(n);

        int k = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (log[i] == 0) continue;
            answer.append(i + " " + log[i] + "\n");
            k++;
        }
        System.out.print(k + "\n" + answer);
    }

    private static void dijkstra(int n) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        queue.offer(new Edge(1, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (visit[edge.to]) continue;
            visit[edge.to] = true;

            for (Edge nextEdge : edges[edge.to]) {
                if (times[nextEdge.to] > times[edge.to] + nextEdge.time) {
                    times[nextEdge.to] = times[edge.to] + nextEdge.time;
                    queue.offer(new Edge(nextEdge.to, times[nextEdge.to]));
                    log[nextEdge.to] = edge.to;
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int to;
        int time;

        public Edge(int to, int time) {
            this.to =  to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }
}

// Kruskal인줄 알았는데, Dijkstra였다 ,, 문제를 더 꼼꼼히 읽어야겠다.