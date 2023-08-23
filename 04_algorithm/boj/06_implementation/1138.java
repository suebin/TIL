import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] log = new int[n];
        for (int i = 0; i < n; i++) {
            log[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> heights = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            heights.add(log[i - 1], i);
        }

        StringBuilder result = new StringBuilder();
        for (int height : heights) {
            result.append(height).append(' ');
        }

        System.out.println(result);
        reader.close();
    }
}