import java.util.*;
import java.io.*;

public class Main {
    static int[] preLocation = new int[100001];
    static int[] time = new int[100001];
    static final int MAX_LOCATION = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();

        bfs(n, k);

        answer.append((time[k] - 1) + "\n");

        Stack<Integer> path = new Stack<>();
        path.push(k);
        while (k != n) {
            path.push(preLocation[k]);
            k = preLocation[k];
        }
        while (!path.isEmpty()) {
            answer.append(path.pop() + " ");
        }

        System.out.println(answer);
        reader.close();
    }

    static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            int location = queue.poll();

            if (location == k) return;

            int nextLocation = 0;
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        nextLocation = location * 2;
                        break;
                    case 1:
                        nextLocation = location + 1;
                        break;
                    case 2:
                        nextLocation = location - 1;
                }

                if (nextLocation < 0 || nextLocation > MAX_LOCATION) {
                    continue;
                }

                if (time[nextLocation] == 0) {
                    queue.add(nextLocation);
                    preLocation[nextLocation] = location;
                    time[nextLocation] = time[location] + 1;
                }
            }
        }
    }
}