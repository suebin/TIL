import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<int[]>[] usado = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            usado[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(reader.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            usado[p].add(new int[]{q, r});
            usado[q].add(new int[]{p, r});
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(reader.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visit = new boolean[N + 1];
            int count = 0;

            queue.add(v);
            visit[v] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();
                visit[now] = true;

                for (int[] info : usado[now]) {
                    if (!visit[info[0]] && info[1] >= k) {
                        queue.add(info[0]);
                        count++;
                    }
                }
            }

            result.append(count).append('\n');
        }

        System.out.println(result);
    }
}