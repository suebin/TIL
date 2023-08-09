import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;
    private static int minCost = 0;
    private static boolean isConnected = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int[][] fields = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            fields[i][0] = Integer.parseInt(st.nextToken());
            fields[i][1] = Integer.parseInt(st.nextToken());
        }

        List<Pipe> pipeList = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = (fields[i][0] - fields[j][0]) * (fields[i][0] - fields[j][0])
                        + (fields[i][1] - fields[j][1]) * (fields[i][1] - fields[j][1]);

                if (cost >= c) {
                    pipeList.add(new Pipe(i, j, cost));
                }
            }
        }

        kruskal(pipeList, n);

        System.out.println(isConnected ? minCost : -1);
        reader.close();
    }

    private static void kruskal(List<Pipe> pipeList, int n) {
        Collections.sort(pipeList);

        int pipeCnt = 0;

        for (Pipe pipe : pipeList) {
            if (!isUnion(pipe.startField, pipe.endField)) {
                union(pipe.startField, pipe.endField);
                pipeCnt++;
                minCost += pipe.cost;
            }

            if (pipeCnt == n - 1) {
                isConnected = true;
                break;
            }
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parents[y] = x;
    }

    private static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        return false;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }

    private static class Pipe implements Comparable<Pipe> {
        int startField;
        int endField;
        int cost;

        public Pipe(int startField, int endField, int cost) {
            this.startField = startField;
            this.endField = endField;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pipe o) {
            return this.cost - o.cost;
        }
    }
}