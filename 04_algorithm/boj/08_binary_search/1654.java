import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
            max = Math.max(max, arr[i]);
        }

        max++;

        long min = 0;

        while (min < max) {
            long mid = (min + max) / 2;
            int count = 0;

            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}