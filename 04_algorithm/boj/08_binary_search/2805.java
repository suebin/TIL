import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] heights = new int[n];
        st = new StringTokenizer(reader.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, heights[i]);
        }

        System.out.println(findMaxHeight(heights, m, max));
        reader.close();
    }

    private static long findMaxHeight(int[] heights, int m, long max) {
        long min = 1;

        while (min < max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int height : heights) {
                if (height > mid) cnt += (height - mid);
            }

            if (cnt < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return max - 1;
    }
}