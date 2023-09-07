import java.util.*;
import java.io.*;

public class Main {
    private static List<Node>[] connect;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        connect = new ArrayList[n + 1];
        cost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            connect[i] = new ArrayList<>();
        }

        Arrays.fill(cost, 500000001);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            connect[a].add(new Node(b, c));
            connect[b].add(new Node(a, c));
        }

        dijkstra();
        System.out.print(cost[n]);
        reader.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(1, 0));
        cost[1] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node nextNode : connect[node.n]) {
                if (cost[nextNode.n] > cost[node.n] + nextNode.cost) {
                    cost[nextNode.n] = cost[node.n] + nextNode.cost;
                    queue.offer(new Node(nextNode.n, cost[nextNode.n]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}