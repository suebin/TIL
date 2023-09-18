import java.util.*;
import java.io.*;

public class Main {
    private static int[] dist;
    private static List<List<Node>> list;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(reader.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        list = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(reader.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (i == K) result.append(0);
            else if (dist[i] == INF) result.append("INF");
            else result.append(dist[i]);

            result.append('\n');
        }

        System.out.print(result);
        reader.close();
    }

    private static void dijkstra(int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(k, 0));
        dist[k] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Node> nextNodeList = list.get(node.v);

            for (Node nextNode : nextNodeList) {
                if (dist[node.v] + nextNode.w < dist[nextNode.v]) {
                    dist[nextNode.v] = dist[node.v] + nextNode.w;
                    queue.offer(new Node(nextNode.v, dist[nextNode.v]));
                }
            }
        }

    }

    private static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}