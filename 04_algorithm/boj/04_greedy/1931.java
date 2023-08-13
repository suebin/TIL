import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] time = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int preEndTime = 0;
        int count = 0;

        for (int[] t : time) {
            if (preEndTime <= t[0]) {
                count++;
                preEndTime = t[1];
            }
        }

        System.out.println(count);
        reader.close();
    }
}