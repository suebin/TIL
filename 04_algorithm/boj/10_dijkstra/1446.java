import java.util.*;
import java.io.*;

public class Main {
    private static int n, d;
    private static List<Way> ways;
    private static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        ways = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (startPoint > d || endPoint > d || endPoint - startPoint <= dist) continue;

            ways.add(new Way(startPoint, endPoint, dist));
        }

        Collections.sort(ways);

        dist = new int[d + 1];

        for (int i = 1; i <= d; i++) {
            dist[i] = i;
        }

        for (Way way : ways) {
            if (dist[way.endPoint] - dist[way.startPoint] > way.dist) {
                dist[way.endPoint] = way.dist + dist[way.startPoint];

                for (int i = way.endPoint + 1; i <= d; i++) {
                    if (dist[i] > dist[i - 1] + 1) {
                        dist[i] = dist[i - 1] + 1;
                    }
                }
            }
        }

        System.out.print(dist[d]);

    }

    private static class Way implements Comparable<Way> {
        int startPoint;
        int endPoint;
        int dist;

        public Way(int startPoint, int endPoint, int dist) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.dist = dist;
        }

        @Override
        public int compareTo(Way o) {
            if (this.startPoint == o.startPoint) return this.dist - o.dist;
            return this.startPoint - o.startPoint;
        }
    }
}