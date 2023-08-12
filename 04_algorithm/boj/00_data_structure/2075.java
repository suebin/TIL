import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            }
        }

        for (int i = 1; i < n; i++) {
            queue.poll();
        }

        System.out.println(queue.peek());
        reader.close();
    }
}