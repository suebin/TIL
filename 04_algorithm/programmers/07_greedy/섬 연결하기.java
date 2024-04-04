import java.util.*;

class Solution {
    private static int[] parents;
    private static int answer;

    public int solution(int n, int[][] costs) {
        kruskal(n, costs);
        return answer;
    }

    private static void kruskal(int n, int[][] costs) {
        answer = 0;
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        PriorityQueue<Island> queue = new PriorityQueue<>();
        for (int[] cost : costs) {
            queue.offer(new Island(cost[0], cost[1], cost[2]));
        }

        while (!queue.isEmpty()) {
            Island island = queue.poll();
            if (union(island.from, island.to)) answer += island.cost;
        }
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

    private static class Island implements Comparable<Island> {
        int from;
        int to;
        int cost;

        public Island(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Island o) {
            return this.cost - o.cost;
        }
    }
}