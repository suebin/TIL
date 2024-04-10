import java.util.*;

class Solution {
    private static List<String> routes;
    private static boolean[] visit;

    public String[] solution(String[][] tickets) {
        routes = new ArrayList<>();
        visit = new boolean[tickets.length];

        dfs("ICN", "ICN", 0, tickets);

        Collections.sort(routes);
        return routes.get(0).split(" ");
    }

    private static void dfs(String departure, String route, int depth, String[][] tickets) {
        if (depth == tickets.length) {
            routes.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && tickets[i][0].equals(departure)) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], depth + 1, tickets);
                visit[i] = false;
            }
        }
    }
}