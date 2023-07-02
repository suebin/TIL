class Solution {
    static final int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int route[][] = new int[n  + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            route[puddles[i][1]][puddles[i][0]] = -1;
        }

        route[1][1] = 1;
        for(int i = 1; i <  n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (route[i][j] == -1) {
                    continue;
                }
                if (route[i-1][j] > 0) {
                    route[i][j] += route[i-1][j] % mod;
                }
                if (route[i][j-1] > 0) {
                    route[i][j] += route[i][j-1] % mod;
                }
            }
        }
        answer = route[n][m] % mod;
        return answer;
    }
}