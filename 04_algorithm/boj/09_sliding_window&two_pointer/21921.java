import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] counts = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = x;
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += counts[i];
        }

        int ans = sum;
        int period = 1;

        while (end < n) {
            sum = sum - counts[start++] + counts[end++];

            if (sum > ans) {
                ans = sum;
                period = 1;
            } else if (sum == ans) {
                period++;
            }
        }

        if (ans == 0) {
            System.out.print("SAD");
        } else {
            System.out.print(ans + "\n" + period);
        }
    }
}