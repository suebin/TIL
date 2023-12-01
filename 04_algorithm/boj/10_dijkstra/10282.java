import java.util.*;
import java.io.*;

public class Main {
    private static List<Node>[] nodes;
    private static int[] times;
    private static boolean[] visit;
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            times = new int[n + 1];
            visit = new boolean[n + 1];
            nodes = new ArrayList[n + 1];

            for (int j = 1; j <= n; j++) {
                times[j] = MAX_VALUE;
                nodes[j] = new ArrayList<>();
            }

            times[c] = 0;

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                nodes[b].add(new Node(a, s));
            }

            dijkstra(new Node(c, 0));

            int cnt = 0;
            int time = 0;

            for (int j = 1; j <= n; j++) {
                if (times[j] != MAX_VALUE) {
                    cnt++;

                    if (times[j] > time) {
                        time = times[j];
                    }
                }

            }
            answer.append(cnt).append(" ").append(time).append("\n");
        }

        System.out.println(answer);
    }

    private static void dijkstra(Node node) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            node = queue.poll();

            if (visit[node.num]) continue;
            visit[node.num] = true;

            for (Node n : nodes[node.num]) {
                if (times[n.num] > times[node.num] + n.time) {
                    times[n.num] = times[node.num] + n.time;
                    queue.offer(new Node(n.num, times[n.num]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}