import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(friends[i], i);
        }

        int[][] logs = new int[len][len];
        int[] val = new int[len];

        for (String gift : gifts) {
            String[] name = gift.split(" ");
            int a = map.get(name[0]);
            int b = map.get(name[1]);
            logs[a][b]++;
            val[a]++;
            val[b]--;
        }

        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (logs[i][j] > logs[j][i]) cnt++;
                else if (logs[i][j] == logs[j][i] && val[i] > val[j]) cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}