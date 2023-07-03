class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i, computers, check);
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int computerNum, int[][] computers, boolean[] check) {
        check[computerNum] = true;
        for (int j = 0; j < computers.length; j++) {
            if (computers[computerNum][j] == 1 && check[j] == false) {
                dfs(j, computers, check);
            }
        }
    }
}