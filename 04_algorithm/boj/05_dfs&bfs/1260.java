import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] nums;
    static boolean[] visit;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        nums = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nums[a][b] = nums[b][a] = 1;
        }

        dfs(v);

        result.append('\n');
        visit = new boolean[n + 1];

        bfs(v);

        System.out.println(result);
        reader.close();
    }

    static void dfs(int v) {
        visit[v] = true;
        result.append(v).append(' ');

        for (int i = 1; i < nums.length; i++) {
            if (!visit[i] && nums[v][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        visit[v] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            result.append(num).append(' ');

            for (int i = 1; i < nums.length; i++) {
                if (!visit[i] && nums[num][i] == 1) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}