import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (x, y) -> Integer.compare(x[1], y[1]));

        int answer = 1;
        int max = routes[0][1];

        for (int[] route : routes) {
            if (route[0] > max) {
                answer++;
                max = route[1];
            }
        }

        return answer;
    }
}