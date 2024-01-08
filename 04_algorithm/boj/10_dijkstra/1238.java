import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List[] list = new ArrayList[n + 1];
        List[] reverseList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<City>();
            reverseList[i] = new ArrayList<City>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new City(end, time));
            reverseList[end].add(new City(start, time));
        }

        int[] distToAllCityFromX = dijkstra(list, x);
        int[] distToXFromAllCity = dijkstra(reverseList, x);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, distToAllCityFromX[i] + distToXFromAllCity[i]);
        }

        System.out.print(ans);
    }

    private static int[] dijkstra(List[] list, int x) {
        Queue<City> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        queue.offer(new City(x, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[x] = 0;

        while (!queue.isEmpty()) {
            City city = queue.poll();
            visit[city.location] = true;

            List<City> nextCityList = list[city.location];
            for (City nextCity : nextCityList) {
                if (!visit[nextCity.location] && dist[city.location] + nextCity.time < dist[nextCity.location]) {
                    dist[nextCity.location] = dist[city.location] + nextCity.time;
                    queue.offer(new City(nextCity.location, dist[nextCity.location]));
                }
            }
        }

        return dist;
    }

    private static class City implements Comparable<City> {
        int location;
        int time;

        public City(int destination, int time) {
            this.location = destination;
            this.time = time;
        }

        @Override
        public int compareTo(City o) {
            return this.time - o.time;
        }
    }
}