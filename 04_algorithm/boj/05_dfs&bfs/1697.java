import java.util.*;
import java.io.*;

public class Main {
    private static int[] time = new int[100001];
    private static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            minTime = n - k;
        }

        bfs(n, k);

        System.out.println(minTime);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int location = queue.poll();

            if (location == k) {
                minTime = time[location];
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nextLocation = 0;
                switch (i) {
                    case 0:
                        nextLocation = location - 1;
                        break;
                    case 1:
                        nextLocation = location + 1;
                        break;
                    case 2:
                        nextLocation = location * 2;
                }

                if (nextLocation < 0 || nextLocation > 100000) continue;

                if (time[nextLocation] == 0 || time[nextLocation] == time[location] + 1) {
                    queue.add(nextLocation);
                    time[nextLocation] = time[location] + 1;
                }
            }
        }
    }
}