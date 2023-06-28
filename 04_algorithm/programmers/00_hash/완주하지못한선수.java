import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> players = new HashMap<>();
        for (String player : participant) {
            players.put(player, players.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            players.put(player, players.getOrDefault(player, 0) - 1);
        }

        for (Map.Entry<String, Integer> entry : players.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }

        return answer;
    }
}