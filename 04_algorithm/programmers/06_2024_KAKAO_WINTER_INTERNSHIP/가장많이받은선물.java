import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        answer = new int[4];

        nodes = new List[1000001];
        boolean[] check = new boolean[1000001];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 1000001; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            nodes[edge[0]].add(edge[1]);
            if (!check[edge[0]]) {
                set.add(edge[0]);
                check[edge[0]] = true;
            }
            set.remove(edge[1]);
        }

        for (int node : set) {
            if (nodes[node].size() >= 2) {
                answer[0] = node;
                break;
            }
        }

        for (int node : nodes[answer[0]]) {
            find(node);
        }

        return answer;
    }

    private static void find(int node) {
        boolean[] check = new boolean[1000001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        check[node] = true;

        int nodeCnt = 0;
        int edgeCnt = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            nodeCnt++;

            List<Integer> nextNodes = nodes[node];

            for (int nextNode : nextNodes) {
                if (!check[nextNode]) {
                    queue.offer(nextNode);
                    check[nextNode] = true;
                    edgeCnt++;
                }
            }
        }

        checkType(nodeCnt, edgeCnt);
    }

    private static void checkType(int nodeCnt, int edgeCnt) {
        if (nodeCnt == edgeCnt) answer[1]++;
        else if (nodeCnt > edgeCnt) answer[2]++;
        else answer[3]++;
    }
}