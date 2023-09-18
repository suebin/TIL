import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static List<List<Node>> list;
    private static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(reader.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int route1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int route2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        System.out.print(route1 >= INF && route2 >= INF ? -1 : Math.min(route1, route2));
        reader.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Node> nextNodeList = list.get(node.v);

            for (Node nextNode : nextNodeList) {
                if (dist[nextNode.v] > dist[node.v] + nextNode.c) {
                    dist[nextNode.v] = dist[node.v] + nextNode.c;
                    queue.offer(new Node(nextNode.v, dist[nextNode.v]));
                }
            }
        }

        return dist[end];
    }

    private static class Node implements Comparable<Node> {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
}