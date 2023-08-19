import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lengths = new int[n];
        int max = 0;
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
            if (lengths[i] > max) max = lengths[i];
        }

        int min = 1;
        max++;

        while (min < max) {
            int mid = (min + max) / 2;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += lengths[i] / mid;
            }

            if (cnt < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max - 1);
        reader.close();
    }
}