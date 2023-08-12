import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int turn = 0;
        StringBuilder josephus = new StringBuilder();
        josephus.append("<");

        while(queue.size() > 1) {
            turn++;

            if (turn == k) {
                josephus.append(queue.poll()).append(", ");
                turn = 0;
                continue;
            }

            queue.offer(queue.poll());
        }

        josephus.append(queue.poll()).append(">");
        System.out.println(josephus);
        reader.close();
    }
}