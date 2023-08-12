import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (num == 0) {
                if (queue.isEmpty()) result.append(0).append('\n');
                else result.append(queue.poll()).append('\n');
            } else {
                queue.offer(num);
            }
        }

        System.out.println(result);
        reader.close();
    }
}