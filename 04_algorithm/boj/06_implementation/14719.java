import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        int[] height = new int[w];

        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            int right = 0;
            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, height[j]);
            }

            h = Math.min(left, right);
            if (h > height[i]) sum += h - height[i];
        }

        System.out.print(sum);
        reader.close();
    }
}