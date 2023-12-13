import java.io.*;
import java.util.*;

public class Main {
    private static char[][] girls;
    private static int[] princesses;
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        girls = new char[5][5];
        princesses = new int[7];

        for (int i = 0; i < 5; i++) {
            char[] row = reader.readLine().toCharArray();
            girls[i] = row;
        }

        find(0, 0, 0);
        System.out.print(answer);
    }

    private static void find(int depth, int idx, int cnt) {
        if (idx == 7) {
            if (cnt >= 4) {
                check();
            }
            return;
        }

        if (depth == 25) return;

        princesses[idx] = depth;
        find(depth + 1, idx + 1, girls[depth / 5][depth % 5] == 'S' ? cnt + 1 : cnt);
        find(depth + 1, idx, cnt);

    }

    private static void check() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[7];

        queue.offer(princesses[0]);
        visit[0] = true;

        int connectedCnt = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 4; i++) {
                for (int next = 1; next < 7; next++) {
                    if (!visit[next] && (now / 5) + dx[i] == princesses[next] / 5 && (now % 5) + dy[i] == princesses[next] % 5) {
                        visit[next] = true;
                        queue.offer(princesses[next]);
                        connectedCnt++;
                    }
                }
            }
        }

        if (connectedCnt == 7) answer++;
    }
}