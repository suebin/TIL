import java.util.*;
import java.io.*;

public class Main {
    private static int f;
    private static int s;
    private static int g;
    private static int u;
    private static int d;
    private static int[] visit;
    private static int[] direction;
    private static final String NOTICE = "use the stairs";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        if ((s < g  && u == 0) || (s > g && d == 0)) {
            System.out.println(NOTICE);
            return;
        }

        visit = new int[f + 1];
        direction = new int[]{u, -d};

        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visit[s] = 1;

        while (!queue.isEmpty()) {
            int floor = queue.poll();

            if (floor == g) return String.valueOf(visit[floor] - 1);

            for (int i = 0; i < 2; i++) {
                int nextFloor = floor + direction[i];

                if (nextFloor < 1 || nextFloor > f) continue;

                if (visit[nextFloor] == 0) {
                    queue.add(nextFloor);
                    visit[nextFloor] = visit[floor] + 1;
                }
            }
        }

        return NOTICE;
    }
}