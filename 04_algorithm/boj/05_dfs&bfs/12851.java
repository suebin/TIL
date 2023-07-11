import java.util.*;
import java.io.*;

public class Main {
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);

        System.out.println(minTime);
        System.out.println(count);

        reader.close();
    }

    static void bfs(int n, int k) {
        if (n >= k) {
            minTime = n - k;
            count = 1;
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int nowLocation = queue.poll();

            if (time[nowLocation] > minTime - 1) {
                return;
            }

            int nextLocation = 0;

            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        nextLocation = nowLocation - 1;
                        break;
                    case 1:
                        nextLocation = nowLocation + 1;
                        break;
                    case 2:
                        nextLocation = nowLocation * 2;
                }

                if (0 > nextLocation || nextLocation > 100000) {
                    continue;
                }

                if (nextLocation == k) {
                    minTime = time[nowLocation] + 1;
                    count++;
                }

                if (time[nextLocation] == 0 || time[nextLocation] == time[nowLocation] + 1) {
                    queue.add(nextLocation);
                    time[nextLocation] = time[nowLocation] + 1;
                }
            }
        }
    }
}