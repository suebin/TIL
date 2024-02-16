class Solution {
    private static int[][] edgeCnt;
    private static int[] answer;
    private static final int OUT = 0;
    private static final int IN = 1;

    public int[] solution(int[][] edges) {
        answer = new int[4];
        edgeCnt = new int[1000001][2];

        int n = 0;
        for (int[] edge : edges) {
            edgeCnt[edge[0]][OUT]++;
            edgeCnt[edge[1]][IN]++;
            n = max(n, edge[0], edge[1]);
        }

        answer[0] = findNewNode(n);
        disconnect(edges, answer[0]);
        countGraphType(n);

        return answer;
    }

    private static void countGraphType(int n) {
        for (int i = 1; i <= n; i++) {
            if (answer[0] == i) continue;

            int inCnt = edgeCnt[i][IN];
            int outCnt = edgeCnt[i][OUT];

            if (inCnt == 0) answer[2]++;
            else if (inCnt == 2 && outCnt == 2) answer[3]++;
        }
        answer[1] = edgeCnt[answer[0]][OUT] - (answer[2] + answer[3]);
    }

    private static void disconnect(int[][] edges, int i) {
        for (int[] edge : edges) {
            if (edge[OUT] == i) edgeCnt[edge[IN]][IN]--;
        }
    }

    private static int findNewNode(int n) {
        for (int i = 1; i <= n; i++) {
            if (edgeCnt[i][IN] == 0 && edgeCnt[i][OUT] > 1) return i;
        }
        return 0;
    }

    private static int max(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}