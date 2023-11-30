import java.util.*;
import java.io.*;

public class Main {
    private static int[] dp;
    private static boolean[] visit;
    private static List<Bus>[] busList;
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        visit = new boolean[n + 1];
        busList = new ArrayList[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            busList[i] = new ArrayList<>();
            dp[i] = MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int departures = Integer.parseInt(st.nextToken());
            int arrivals = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busList[departures].add(new Bus(arrivals, cost));
        }

        st = new StringTokenizer(reader.readLine());
        int myDepartures = Integer.parseInt(st.nextToken());
        int myArrivals = Integer.parseInt(st.nextToken());

        dp[myDepartures] = 0;
        dijkstra(new Bus(myDepartures, 0));

        System.out.print(dp[myArrivals]);
        reader.close();
    }

    private static void dijkstra(Bus bus) {
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.offer(bus);

        while (!queue.isEmpty()) {
            bus = queue.poll();
            if (visit[bus.departures]) continue;
            visit[bus.departures] = true;

            for (Bus nextBus : busList[bus.departures]) {
                if (!visit[nextBus.departures]
                        && dp[nextBus.departures] > dp[bus.departures] + nextBus.cost) {
                    dp[nextBus.departures] = dp[bus.departures] + nextBus.cost;
                    queue.offer(new Bus(nextBus.departures, dp[nextBus.departures]));
                }
            }
        }
    }

    private static class Bus implements Comparable<Bus> {
        int departures;
        int cost;

        public Bus(int departures, int cost) {
            this.departures = departures;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }
}