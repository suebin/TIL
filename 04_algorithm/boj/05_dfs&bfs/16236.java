import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        map = new int[n][n];
        Shark shark = null;
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                int status = Integer.parseInt(st.nextToken());
                map[i][j] = status;

                if (status == 9) {
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }

        getTimeForSharkToEatFish(shark);
    }

    private static void getTimeForSharkToEatFish(Shark shark) {
        int timeForSharkToEatFish = 0;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int numFishEaten = 0;

        while (true) {
            PriorityQueue<Shark> queue = new PriorityQueue<>();
            boolean[][] visit = new boolean[n][n];

            queue.add(shark);
            shark.hasEaten = false;
            visit[shark.x][shark.y] = true;

            while (!queue.isEmpty()) {
                shark = queue.poll();

                if (shark.isEatable(map[shark.x][shark.y])) {
                    numFishEaten++;
                    shark.hasEaten = true;
                    timeForSharkToEatFish += shark.movementTime;
                    shark.movementTime = 0;
                    map[shark.x][shark.y] = 0;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = shark.x + dx[i];
                    int nextY = shark.y + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                        continue;
                    }

                    if (shark.isMovable(map[nextX][nextY]) && !visit[nextX][nextY]) {
                        queue.add(new Shark(nextX, nextY, shark.size, shark.movementTime + 1));
                        visit[nextX][nextY] = true;
                    }
                }
            }

            if (!shark.hasEaten) {
                break;
            }

            if (numFishEaten == shark.size) {
                shark.size++;
                numFishEaten = 0;
            }
        }

        System.out.println(timeForSharkToEatFish);
    }

    private static class Shark implements Comparable<Shark> {
        private int x;
        private int y;
        private int size;
        private int movementTime;
        private boolean hasEaten;

        public Shark(int x, int y, int size, int movementTime) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.movementTime = movementTime;
        }

        @Override
        public int compareTo(Shark shark) {
            if (this.movementTime != shark.movementTime) return this.movementTime - shark.movementTime;
            else if (this.x != shark.x) return this.x - shark.x;
            else return this.y - shark.y;
        }

        public boolean isEatable(int statusOfMap) {
            return this.size > statusOfMap && statusOfMap != 0;
        }

        public boolean isMovable(int statusOfMap) {
            return statusOfMap <= this.size;
        }
    }
}