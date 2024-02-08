import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        if (k >= n) {
            System.out.print(0);
            return;
        }

        int[] sensors = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(getMinVal(n, k, sensors));
    }

    private static int getMinVal(int n, int k, int[] sensors) {
        Arrays.sort(sensors);
        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(dist);

        int minVal = 0;
        for (int i = 0; i < n - k; i++) {
            minVal += dist[i];
        }
        return minVal;
    }
}