import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] nodes = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] node : edge) {
            int a = node[0];
            int b = node[1];

            nodes[a].add(b);
            nodes[b].add(a);
        }

        int answer = bfs(nodes, n);
        return answer;
    }

    private static int bfs(List<Integer>[] nodes, int n) {
        int max = 0;
        int cnt = 0;
        boolean[] visit = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit[node.n] = true;

            if (node.d > max) {
                max = node.d;
                cnt = 1;
            } else if (node.d == max) {
                cnt++;
            }

            List<Integer> nextNodeList = nodes[node.n];

            for (int nextNode : nextNodeList) {
                if (!visit[nextNode]) {
                    queue.add(new Node(nextNode, node.d + 1));
                    visit[nextNode] = true;
                }
            }
        }

        return cnt;

    }

    private static class Node {
        int n;
        int d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}