import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_LOCATION = 100000;
    static boolean[] visit = new boolean[100001];
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);

        System.out.print(minTime);
        reader.close();
    }

    static void bfs(int n, int k) {
        Queue<Subin> queue = new LinkedList<>();
        queue.add(new Subin(n, 0));

        int nextLocation = 0;
        while (!queue.isEmpty()) {
            Subin subin = queue.poll();

            visit[subin.location] = true;

            if (subin.location == k) {
                minTime = Math.min(minTime, subin.time);
            }

            nextLocation = subin.location * 2;
            if (nextLocation <= MAX_LOCATION && !visit[nextLocation]) {
                queue.add(new Subin(nextLocation, subin.time));
            }

            nextLocation = subin.location + 1;
            if (nextLocation <= MAX_LOCATION && !visit[nextLocation]) {
                queue.add(new Subin(nextLocation, subin.time + 1));
            }

            nextLocation = subin.location - 1;
            if (nextLocation >= 0 && !visit[nextLocation]) {
                queue.add(new Subin(nextLocation, subin.time + 1));
            }
        }
    }

    static class Subin {
        int location;
        int time;

        public Subin(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
}