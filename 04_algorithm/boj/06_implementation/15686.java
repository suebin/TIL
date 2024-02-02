import java.io.*;
import java.util.*;

public class Main {
    private static int m;
    private static List<Point> chickens;
    private static List<Point> houses;
    private static int answer;
    private static int[] selected;
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        answer = MAX_VALUE;
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];

        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) houses.add(new Point(i, j));
                if (info == 2) chickens.add(new Point(i, j));
            }
        }

        find(0, 0);
        System.out.print(answer);
    }

    private static void find(int idx, int depth) {
        if (depth == m) {
            answer = Math.min(answer, getCityChickenDist());
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            selected[depth] = i;
            find(i + 1, depth + 1);
        }
    }

    private static int getCityChickenDist() {
        int sum = 0;
        for (Point house : houses) {
            int min = MAX_VALUE;
            for (int i : selected) {
                Point chicken = chickens.get(i);
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(dist, min);
            }
            sum += min;
        }

        return sum;
    }

    private static class Point {
        int x;
        int y;


        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}